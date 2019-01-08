package com.fedak.denis.mymvvm.dagger.module


import com.fedak.denis.mymvvm.fragment.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeDetailFragmentInjector(): DetailFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailImageFragmentInjector() : DetailImageFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailTextFragmentInjector() : DetailTextFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsFragmentInjector() : SettingFragment

    @ContributesAndroidInjector
    abstract fun contributeDeepLinkFragmentInjector() : DeepLinkFragment
}