package com.fehosdsg7.dagger2.di

import androidx.lifecycle.ViewModel
import com.fehosdsg7.dagger2.data.MockData
import com.fehosdsg7.dagger2.domain.IteratorClass
import com.fehosdsg7.dagger2.presentation.first.MainViewModel
import com.fehosdsg7.dagger2.presentation.second.SecondViewModel
import com.fehosdsg7.dagger2.presentation.third.ThirdViewModel
import com.fehosdsg7.dagger2.presentation.utils.MultiViewModelFactory
import com.fehosdsg7.dagger2.presentation.utils.ViewModelKey
import dagger.*
import dagger.multibindings.IntoMap
import java.lang.annotation.Documented
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent{

}

@Module
class AppModule {

    @Provides
    @Reusable
    fun providesInteractor(mockData: MockData) : IteratorClass {
        return IteratorClass(mockData)
    }
    @Provides
    @Reusable
    fun provideRepositore() : MockData {
        return MockData()
    }
}

@FirstAndSecondScope
@Component(modules = [ViewModelModel1::class])
interface FirstAndSecondComponent{
    fun viewModelFactory() : MultiViewModelFactory
}

@ThirdScope
@Component(modules = [ViewModelModel2::class])
interface ThirdComponent{

    fun viewModelFactory() : MultiViewModelFactory
}

@Module
interface ViewModelModel1{

    @Binds
    @FirstAndSecondScope
    @[IntoMap ViewModelKey(SecondViewModel::class)]
    fun provideSecondViewModel(secondViewModelData: SecondViewModel) : ViewModel

    @Binds
    @FirstAndSecondScope
    @[IntoMap ViewModelKey(MainViewModel::class)]
    fun provideMainViewModel(secondViewModelData: MainViewModel) : ViewModel

}

@Module
interface ViewModelModel2{

    @Binds
    @ThirdScope
    @[IntoMap ViewModelKey(ThirdViewModel::class)]
    fun provideSecondViewModel(secondViewModelData: ThirdViewModel) : ViewModel
}


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FirstAndSecondScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ThirdScope

