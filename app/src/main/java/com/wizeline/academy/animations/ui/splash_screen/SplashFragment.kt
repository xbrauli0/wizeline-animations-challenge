package com.wizeline.academy.animations.ui.splash_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewPropertyAnimator
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.wizeline.academy.animations.databinding.SplashFragmentBinding

class SplashFragment : Fragment() {

    private var _binding: SplashFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SplashFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        buildAnimation()
//        lifecycleScope.launch {
//            delay(2000)
//            goToHomeScreen()
//        }
    }

    private fun buildAnimation() {
//        val aparecer = ObjectAnimator.ofFloat(binding.ivWizelineLogo,"alpha",1f)
//        val crecerX = ObjectAnimator.ofFloat(binding.ivWizelineLogo,"scaleX",3f)
//        val crecerY = ObjectAnimator.ofFloat(binding.ivWizelineLogo,"scaleY",3f)
//        val animSet1 = AnimatorSet()
//        animSet1.duration = 1000
//        animSet1.playTogether(aparecer,crecerX,crecerY)
//        animSet1.start()
//
//        val restablecerX = ObjectAnimator.ofFloat(binding.ivWizelineLogo,"scaleX",1f)
//        val restablecerY = ObjectAnimator.ofFloat(binding.ivWizelineLogo,"scaleY",1f)
//        val animSet2 = AnimatorSet()
//        animSet2.duration = 1000
//        animSet2.playTogether(restablecerX,restablecerY)
//
//        animSet1.doOnEnd {
//            animSet2.start()
//        }
        binding.ivWizelineLogo.animate().apply {
            duration = 1000
            alpha(1f)
            scaleX(3f)
            scaleY(3f)
            withEndAction {
                animation2(this)
            }
        }
    }

    private fun animation2(viewPropertyAnimator: ViewPropertyAnimator) {
        with(viewPropertyAnimator) {
            duration = 1000
            scaleX(1f)
            scaleY(1f)
            withEndAction {
                goToHomeScreen()
            }
        }
    }

    private fun goToHomeScreen() {
        val directions = SplashFragmentDirections.toMainFragment()
        findNavController().navigate(directions)
    }
}