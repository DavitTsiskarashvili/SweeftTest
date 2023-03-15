package com.example.sweefttest

fun main() {

    // Task N1
    println(
        "the number that does not have a duplicate in an array is" +
                " ${singleNumber(numsArray = intArrayOf(23, 25, 67, 25, 23, 44, 44, 88, 88))}"
    )


    // Task N2
    val amount = 87
    println("Minimum number of coins required for $amount tetri is ${minimumCoinsNumber(amount)}")


    // Task N3
    println(
        "Minimum missing positive integer is" +
                " ${
                    missingInt(
                        array = intArrayOf(
                            -7, -2, 1, 2, 5, 12, 11, 4, 6, 7, 8, 9, 10
                        )
                    )
                }"
    )


    // Task N4
    println(
        "The result of adding two binary strings is ${addBinaryStrings("1010", "1011")}"
    )


    // Task N5
    var n = 15
    println(
        "the number of possible ways to climb the ladder of $n steps is ${numberOfWaysToClimb(n)}"
    )


    // Task N6
    println(removeData())

}


// Task N1
/* გვაქვს მთელი რიცხვების ჩამონათვალი სადაც  ერთის გარდა
ყველა რიცხვი  მეორდება, იპოვეთ ის რიცხვი რომელიც არ მეორდება. */

fun singleNumber(numsArray: IntArray): Int {
    var a = 0
    for (i in numsArray) {
        a = a xor i
    }
    return a
}


// Task N2
/* გვაქვს 1,5,10,20 და 50 თეთრიანი მონეტები. დაწერეთ ფუნქცია,
რომელსაც გადაეცემა თანხა (თეთრებში) და აბრუნებს მონეტების მინიმალურ რაოდენობას,
რომლითაც შეგვიძლია ეს თანხა დავახურდაოთ. */

fun minimumCoinsNumber(amount: Int): Int {
    val coins = intArrayOf(50, 20, 10, 5, 1)
    var coinCount = 0
    var remainingAmount = amount

    for (i in coins) {
        if (remainingAmount == 0) break
        coinCount += remainingAmount / i
        remainingAmount %= i
    }
    return coinCount
}


// Task N3
/* მოცემულია მასივი, რომელიც შედგება მთელი რიცხვებისგან. დაწერეთ ფუნქცია რომელსაც
 გადაეცემა ეს მასივი და აბრუნებს მინიმალურ მთელ რიცხვს, რომელიც 0-ზე მეტია და ამ მასივში არ შედის. */

fun missingInt(array: IntArray): Int {
    var missingInt = 1
    val set = HashSet<Int>()

    for (i in array.indices) {
        if (array[i] > 0) {
            set.add(array[i])
        }
    }
    while (set.contains(missingInt)) {
        missingInt++
    }
    return missingInt
}


// Task 4
// მოცემულია ორი binary string a და b, დააბრუნეთ მათი ჯამი, როგორც binary string.

fun addBinaryStrings(a: String, b: String): String {
    var carry = 0
    var result = ""
    var i = a.length - 1
    var k = b.length - 1

    while (i >= 0 || k >= 0 || carry > 0) {
        val sum = carry + (if (i >= 0) a[i--] - '0' else 0) + (if (k >= 0) b[k--] - '0' else 0)
        result = "${sum % 2}$result"
        carry = sum / 2
    }
    return result
}


// Task 5
/* გვაქვს n სართულიანი კიბე, ერთ მოქმედებაში შეგვიძლია ავიდეთ 1 ან 2 საფეხურით.
   დაწერეთ ფუნქცია რომელიც დაითვლის n სართულზე ასვლის ვარიანტების რაოდენობას. */

fun numberOfWaysToClimb(n: Int): Int {
    if (n <= 1) {
        return 1
    }
    var prev1 = 1
    var prev2 = 1
    var current = 0
    for (i in 2..n) {
        current = prev1 + prev2
        prev2 = prev1
        prev1 = current
    }
    return current
}


// Task 6
// დაწერეთ საკუთარი მონაცემთა სტრუქტურა, რომელიც საშუალებას მოგვცემს O(1) დროში წავშალოთ ელემენტი.

fun removeData() {
    val map = LinkedHashMap<Int, String>()
    map[1] = "one"
    map[2] = "two"
    map[3] = "three"
    map[4] = "four"
    map[5] = "five"

    map.remove(4)

    for (i in map) {
        println("${i.key}, ${i.value}")
    }

}

