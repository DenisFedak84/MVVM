package com.fedak.denis.mymvvm.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fedak.denis.mymvvm.R
import com.fedak.denis.mymvvm.databinding.FragmentImageDetailBinding
import com.fedak.denis.mymvvm.utils.DETAIL_URL

class DetailImageFragment : BaseFragment() {

    lateinit var binding: FragmentImageDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_detail, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            val url = DetailImageFragmentArgs.fromBundle(arguments!!)
            binding.url = url.urlArg
    }
}