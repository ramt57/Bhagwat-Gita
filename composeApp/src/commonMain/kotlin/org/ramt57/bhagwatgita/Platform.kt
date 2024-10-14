package org.ramt57.bhagwatgita

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform