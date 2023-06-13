fun main(args: Array<String>) {
    println("Bem vindo ao Bytebank")
    val contaAlex =  Conta("Alex", 1000)
    contaAlex.deposita(200.0)
    println("Titular: ${contaAlex.titular}")
    println("Numero: ${contaAlex.numero}")
    println("Saldo: ${contaAlex.saldo}")
    println("Depositando na conta do Alex")
    contaAlex.deposita(50.00)
    println(contaAlex.saldo)
    println("Sacando na conta do Alex")
    contaAlex.saca(200.0)
    println("Saldo: ${contaAlex.saldo}")

    println("**************************")

    val contaFran = Conta("Fran", 1001)
    contaFran.deposita(300.00) 
    println("Titular: ${contaFran.titular}")
    println("Numero: ${contaFran.numero}")
    println("Saldo: ${contaFran.saldo}")
    println("Depositando na conta da Fran")
    contaFran.deposita( 70.00)
    println(contaFran.saldo)
    println("Sacando na conta da Fran")
    contaFran.saca(70.00)
    println("Saldo: ${contaFran.saldo}")

    println("Tranferindo da conta da Fran")
    if (contaFran.transfere(100.0,contaAlex)){
        println("Tranferência realizada com sucesso")
        println("Saldo da Fran: ${contaFran.saldo}")
        println("Saldo da Alex: ${contaAlex.saldo}")
    }else{
        println("Falha na transferência")
    }
}


class Conta (val titular: String, var numero: Int){
    var saldo = 0.0
        private set

    fun deposita(valor: Double) {
        if (valor > 0){
        saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta):Boolean {
        if (saldo >= valor){
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }
}