package com.cmj.seminario

import java.math.BigInteger
import kotlin.math.pow

fun main(){
    var listaNumeros = listOf(1, 4, 7, 3, 2)
    var cadena = "Till Lindemann es un cantante, actor, poeta, escritor, pirotecnico y ex nadador aleman, " +
                 "conocido mundialmente por ser vocalista de la banda de metal industrial Rammstein."
    var subcadena = "es"
    var letra = 'n'
    var num = 1235321
    var matriz:List<List<Int>> = listOf(listOf(5, 1, 14), listOf(7, 0, 21))
    var listaPalabras:List<String> = listOf("ola", "azucar", "esternocleidomastoideo")
    var listaPalabras2:List<String> = listOf("alo", "banana", "mamawebo")
    var palabra = "ola ke ase?"
    var anagrama1 = "murderer"
    var anagrama2 = "dreemurr"

    //PRUEBAS
    //println("Lista: $listaNumeros")
    //println("Maximo: " + maxLista(listaNumeros))
    //println("Sumatoria: " + sumatoriaLista(listaNumeros))
    //println("1 millas son " + millasAKm(1F) + " km")
    //println("$cadena es palindromo?: " + esPalindromo(cadena))
    //println("$cadena contiene la $letra " + vecesApareceLetra(cadena, letra) + " vez/veces")
    //println("$cadena contiene la subcadena $subcadena " + vecesApareceSubcadena(cadena, subcadena) + " vez/veces")
    //println("Cadena capitalizada: " + capitalizarPrimeraLetra(cadena))
    //println("La suma de los dígitos de $num es " + sumarDigitosNumero(num))
    //println("Máximo común divisor de 64 y 88 es " + maximoComunDivisor(64, 88))
    //println("Sucesión de Fibonacci: " + sucesionFibonacci(9))
    //println("$num es capicua?: " + esCapicua(num))
    //imprimirMosaico(6)
    //println("Producto de la lista $listaNumeros: " + productoLista(listaNumeros.toIntArray()))
    //println("Pares de la lista $listaNumeros: " + devolverParesLista(listaNumeros.toIntArray()))
    //println("$num es primo?: " + esPrimo(num))
    //println("Cadena con las vocales eliminadas: " + eliminarVocalesCadena(cadena))
    //println("Factorial de 5: " + calcularFactorial(5))
    //println("Cadena invertida: " + invertirCadena(cadena))
    //println("Es 6 un numero perfecto?: " + esNumeroPerfecto(6))
    //println("153 es un numero Armstrong?: " + esNumeroArmstrong(153))
    //println("Numero maximo de la matriz $matriz: " + numeroMaxEnMatriz(matriz))
    //println("Numero minimo de la matriz $matriz: " + numeroMinEnMatriz(matriz))
    //println("Palabra mas larga de la lista $listaPalabras: " + cadenaMasLargaDeLista(listaPalabras))
    //println("Palabra mas corta de la lista $listaPalabras: " + cadenaMasCortaDeLista(listaPalabras))
    //println("Palabra $palabra solo contiene caracteres alfabeticos?: " + cadenaSoloContieneCaracteresAlfabeticos(palabra))
    //println("Palabra $anagrama1 y $anagrama2 son anagramas?: " + cadenasSonAnagramas(anagrama1, anagrama2))
    //println("21 es numero triangular?: " + esNumeroTriangular(21))
    //println("Son 11 y 33 primos relativos?: " + sonPrimosRelativos(11, 33))
    //println("in: div.coche#VWPolo -> out: " + emmetAEtiquetaHTML("div.coche#VWPolo"))
    //println("Lista $listaNumeros con elementos duplicados: " + duplicarElementosLista(listaNumeros))
    //println("Mapa a partir de $listaPalabras con $listaPalabras2: " + crearDiccionario(listaPalabras, listaPalabras2))
    //println("Alpaca cifrado a Karaca: " + cifrarAKaraca("alpaca"))
    //println("Test binario $num: " + transformarNumeroDecimalABinario(num))
    println("Lista $listaNumeros ordenada de forma desc: " + ordenarLista(listaNumeros, "Desc"))
}

//Ejercicio 1
fun maxLista(arr: List<Int>): Int?{
    return arr.maxOrNull()
}

//Ejercicio 2
fun sumatoriaLista(arr: List<Int>): Int{
    var sumatoria = 0
    arr.forEach { sumatoria += it }
    return sumatoria
}

//Ejercicio 3
fun millasAKm(millas: Float): Float{
    return millas * 1.60934F
}

//Ejercicio 4
fun esPalindromo(cadena: String): Boolean{
    if(cadena.length % 2 != 0){
        var trozo1 = cadena.substring(0, cadena.length / 2)
        var trozo2 = cadena.substring(cadena.length / 2 + 1, cadena.length).reversed()

        return trozo1.equals(trozo2)
    }else return false
}

//Ejercicio 5
fun vecesApareceLetra(cadena: String, letra: Char): Int{
    var veces = 0
    cadena.forEach {
        if(it.equals(letra)) veces++
    }

    return veces
}

//Ejercicio 6
fun vecesApareceSubcadena(cadena: String, subcadena: String): Int{
    val aux = cadena.lowercase().replace(subcadena.lowercase(), "")

    return (cadena.length - aux.length) / subcadena.length
}

//Ejercicio 7
fun capitalizarPrimeraLetra(cadena: String): String{
    var palabras = cadena.split(" ", "?").toMutableList()

    var p:String
    for(i in 0..palabras.count() - 1){
        p = palabras[i]
        if(p.isNotEmpty())
            if(!p.equals("?"))
                if(p.length > 1){
                    palabras[i] = p.substring(0, 1).uppercase() + p.substring(1, p.length)
                }
                else
                    palabras[i] = p.uppercase()

    }

    return palabras.joinToString(separator = " ")
}

//Ejercicio 8
fun sumarDigitosNumero(num: Int): Int{
    var suma = 0
    val numStr = "" + num

    for(char in numStr){
        suma += char.digitToInt()
    }

    return suma
}

//Ejercicio 9
private fun calcularDivisores(num: Int): List<Int>{
    var divisores:MutableList<Int> = mutableListOf()
    var i = num / 2

    divisores.add(num)
    while(i >= 1){
        if(num % i == 0) divisores.add(i)
        i--
    }

    return divisores
}

fun maximoComunDivisor(a: Int, b: Int): Int{
    var divisoresA = calcularDivisores(a)
    var divisoresB = calcularDivisores(b)
    var mcd = 0

    for(numA in divisoresA){
        if(mcd != 0) break
        for(numB in divisoresB){
            if(numA == numB){
                mcd = numA
                break
            }
        }
    }

    return mcd
}

//Ejercicio 10
fun sucesionFibonacci(n: Int): MutableList<Int>{
    var sucesion:MutableList<Int> = mutableListOf()
    var a = 0
    var b = 1

    sucesion.add(a)
    sucesion.add(b)

    for(i in 1..n){
        a += b
        b += a
        sucesion.add(a)
        sucesion.add(b)
    }

    return sucesion
}

//Ejercicio 11
fun sonPrimosRelativos(a: Int, b: Int): Boolean{
    var divisoresA = calcularDivisores(a)
    var divisoresB = calcularDivisores(b)
    var fcg: Int = 0

    for(numA in divisoresA){
        for(numB in divisoresB){
            if(numA == numB && numA > fcg){
                fcg = numA
            }
        }
    }

    return fcg == 1
}

//Ejercicio 12
fun esCapicua(num: Int): Boolean{
    var cadena = num.toString() //0123456
    if(cadena.length % 2 != 0){ //1235321
        var trozo1 = cadena.substring(0, cadena.length / 2)
        var trozo2 = cadena.substring(cadena.length / 2 + 1, cadena.length).reversed()

        return trozo1.equals(trozo2)
    }else{
        var trozo1 = cadena.substring(0, cadena.length / 2 - 1)
        var trozo2 = cadena.substring(cadena.length / 2 + 1, cadena.length).reversed()

        return trozo1.equals(trozo2)
    }
}

//Ejercicio 13
fun emmetAEtiquetaHTML(cadena: String): String{
    var output:String = "<apertura></cierre>"
    var apertura = ""
    var etiqueta:String = ""
    var clase:String = ""
    var id:String = ""
    var leyendo:String = "ETIQUETA"

    for(char in cadena){
        when(char){
            '.' -> leyendo = "CLASE"
            '#' -> leyendo = "ID"
        }
        when(leyendo){
            "ETIQUETA" -> etiqueta += char
            "CLASE" ->  if(char != '.') clase += char
            "ID" -> if(char != '#') id += char
        }
    }

    //Se construye la salida
    apertura += etiqueta
    if(clase.isNotEmpty()) apertura += " class=\"$clase\""
    if(id.isNotEmpty()) apertura += " id=\"$id\""
    output = output.replace("apertura", apertura)
    output = output.replace("cierre", etiqueta)

    return output
}

//Ejercicio 14
fun imprimirMosaico(n: Int){
    var cadena:String = ""
    for(i in 1..n){
        cadena = ""
        for(j in 1..i){
            cadena += i
        }
        println(cadena)
    }
}

//Ejercicio 15
fun compararArrays(arr1: IntArray, arr2: IntArray): BooleanArray? {
    var arrBol:BooleanArray = BooleanArray(arr1.size)

    if(arr1.size <= arr2.size){
        for(i in arr1.indices){
            arrBol[i] = arr1[i] == arr2[i]
        }
    }else{
        return null
    }
    
    return arrBol
}

//Ejercicio 16
fun productoLista(arr: IntArray): Int{
    var producto:Int = arr[0]

    if(arr.size > 1){
        for(i in arr.indices){
            producto *= arr[i]
        }
    }

    return producto
}

//Ejercicio 17
fun devolverParesLista(arr: IntArray): MutableList<Int>{
    var pares:MutableList<Int> = mutableListOf()

    for(num in arr){
        if(num % 2 == 0){
            pares.add(num)
        }
    }

    return pares
}

//Ejercicio 18
fun esPrimo(num: Int): Boolean{
    return calcularDivisores(num).size == 2
}

//Ejercicio 19
fun eliminarVocalesCadena(cadena: String): String{
    val vocales:List<Char> = listOf('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U')

    return cadena.filter { !vocales.contains(it) }
}

//Ejercicio 20
fun calcularFactorial(num: Int): Int{
    var producto = 1;

    for(i in 1..num){
        producto *= i
    }

    return producto
}

//Ejercicio 21
fun invertirCadena(cadena: String): String{
    return cadena.reversed()
}

//Ejercicio 22
fun esNumeroPerfecto(num: Int): Boolean{
    return sumatoriaLista(calcularDivisores(num) - num) == num
}

//Ejercicio 23
fun esNumeroArmstrong(num: Int): Boolean{
    var numStr = num.toString()
    var exponente:Int = numStr.length
    var suma:Double = 0.0

    for(i in numStr.indices){
        suma += numStr[i].digitToInt().toDouble().pow(exponente)
    }

    return num.toDouble() == suma
}

//Ejercicio 24
fun numeroMaxEnMatriz(matrix: List<List<Int>>): Int{
    var max:Int = 0

    for(arr in matrix){
        for(pos in arr){
            if(pos > max) max = pos
        }
    }

    return max
}

//Ejercicio 25
fun numeroMinEnMatriz(matrix: List<List<Int>>): Int{
    var min:Int = matrix[0][0]

    for(arr in matrix){
        for(pos in arr){
            if(pos < min) min = pos
        }
    }

    return min
}

//Ejercicio 26
fun cadenaMasLargaDeLista(lista: List<String>): String{
    var cadenaMax = "";

    for(str in lista){
        if(str.length > cadenaMax.length){
            cadenaMax = str
        }
    }

    return cadenaMax
}

//Ejercicio 27
fun cadenaMasCortaDeLista(lista: List<String>): String{
    var cadenaMin = lista.get(0);

    for(str in lista){
        if(str.length < cadenaMin.length){
            cadenaMin = str
        }
    }

    return cadenaMin
}

//Ejercicio 28
fun cadenaSoloContieneCaracteresAlfabeticos(cadena: String): Boolean{
    for(char in cadena){
        if(!(char.isLetter() || char.isWhitespace() || cadena.contains("[!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex()))){
            return false
        }
    }

    return true
}

//Ejercicio 29
fun cadenasSonAnagramas(cadena1: String, cadena2: String): Boolean{
    var letrasCadena1 = cadena1.lowercase().toList().sorted()
    var letrasCadena2 = cadena2.lowercase().toList().sorted()

    return letrasCadena1.equals(letrasCadena2)
}

//Ejercicio 30
fun esNumeroTriangular(num: Int): Boolean{
    var suma = 0
    var it = 1

    while(true){
        suma += it

        if(suma > num) return false
        if(suma == num) return true

        it++
    }
}

//Ejercicio 31
fun duplicarElementosLista(lista: List<Int>): List<Int>{
    return lista.map { it * 2 }
}

//Ejercicio 32
fun crearDiccionario(listaClaves: List<String>, listaValores: List<String>): MutableMap<String, String>? {
    var mapa = mutableMapOf<String, String>()

    if(listaValores.size > listaClaves.size){
        println("La lista de valores es más grande que la de claves")
        return null
    }

    for(i in listaValores.indices){
        mapa[listaClaves[i]] = listaValores[i]
    }

    return mapa
}

//Ejercicio 33
fun transformarNumeroDecimalABinario(num:Int): BigInteger{
    var numAux: Int = num
    var numBinario: String = ""

    while(numAux > 0){
        numBinario += numAux % 2
        numAux /= 2
    }

    //Se invierte
    numBinario = numBinario.reversed()

    return numBinario.toBigInteger()
}

//Ejercicio 34
fun cifrarAKaraca(cadena: String): String{
    var cadenaCifrada = cadena.reversed()
    var listaVocales = mapOf("a" to "0",
                             "e" to "1",
                             "i" to "2",
                             "o" to "3",
                             "u" to "4")

    listaVocales.forEach{ (key, value) ->
        cadenaCifrada = cadenaCifrada.replace(key, value)
    }

    cadenaCifrada += "aca"

    return cadenaCifrada
}

//Ejercicio 35
fun ordenarLista(lista: List<Int>, orden: String): List<Int>{
    var listaOrdenada: MutableList<Int> = lista.toMutableList()
    var i = 0
    var j = 0
    var numAux: Int

    when(orden){
        "Asc" -> {
            while(i < listaOrdenada.size){
                j = i
                while(j < listaOrdenada.size){
                    if(listaOrdenada[i] > listaOrdenada[j]){
                        numAux = listaOrdenada[i]
                        listaOrdenada[i] = listaOrdenada[j]
                        listaOrdenada[j] = numAux
                    }
                    j++
                }
                j = 0
                i++
            }
        }
        "Desc" -> {
            while(i < listaOrdenada.size){
                j = i
                while(j < listaOrdenada.size){
                    if(listaOrdenada[i] < listaOrdenada[j]){
                        numAux = listaOrdenada[i]
                        listaOrdenada[i] = listaOrdenada[j]
                        listaOrdenada[j] = numAux
                    }
                    j++
                }
                j = 0
                i++
            }
        }
    }

    return listaOrdenada
}