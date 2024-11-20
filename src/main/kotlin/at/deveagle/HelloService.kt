package at.deveagle

import org.koin.dsl.module

val appModule = module {
    single { HelloService() }
    single { HelloController(get()) }
}

class HelloService {
    fun sayHello(name: String) = "Hy, mein Name ist $name!"
}

class HelloController(private val helloService: HelloService) {
    fun handleRequest(name: String) = helloService.sayHello(name)
}