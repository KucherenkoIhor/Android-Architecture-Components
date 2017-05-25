# Android Architecture Components
![](https://cdn-images-1.medium.com/max/800/1*WVdFMYmEoCdXniy7ulDe5g.png)


## Read article [here](https://medium.com/proandroiddev/android-architecture-components-cb1ea88d3835)
Android Architecture Components (AAC) is a new collection of libraries that contains the lifecycle-aware components. It can solve problems with configuration changes, supports data persistence, reduces boilerplate code, helps to prevent memory leaks and simplifies async data loading into your UI. I can’t say that it brings absolutely new approaches for solving these issues, but, finally, we have a formal, single and official direction.

AAC provides some abstractions to deal with Android lifecycle:
* LifecycleOwner
* LiveData
* ViewModel

The main benefit is the fact that our UI components, like TextView or RecycleView, observe LiveData, which, in turn, observes the lifecycle of an Activity or Fragment, using a LifecycleObserver.

![](https://cdn-images-1.medium.com/max/800/1*KD4TON1jgYjnc7CQuxJIrA.png)

Combination of these components solves main challenges faced by Android developers, such as boilerplate code or modular. To explore and check an example of this concept, I decided to create the sample project. It just gets a list of repositories from Github and shows one using RecyclerView.

![](https://cdn-images-1.medium.com/max/800/1*YTzzwEjS0NNnrxmlgXr6ZA.gif)

As you can see, it handles configuration changes without any problems, and an Activity looks very simple:

![](https://cdn-images-1.medium.com/max/800/1*aSSP4DL-bNEFGnY6aAb00Q.png)

How you have probably noticed, our activity assumes minimum responsibilities. ReposViewModel holds state and view data in the following way:

![](https://cdn-images-1.medium.com/max/800/1*QbWnVVCrIixCTevdDwy40Q.png)
