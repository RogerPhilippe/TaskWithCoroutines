package br.com.philippesis.corotines

import kotlinx.coroutines.*

abstract class CoroutineTask {

    /**
     * Start Coroutine.
     */
    fun run() = GlobalScope.launch(Dispatchers.Main) {
        preExecute()
        withContext(Dispatchers.IO) { execute() }
    }

    /**
     * Execute Coroutine.
     */
    private fun execute() = runBlocking {

        withContext(Dispatchers.IO) {
            doInBackground()
        }
        posExecute()
    }

    abstract fun preExecute()

    abstract fun doInBackground()

    abstract fun posExecute()

}