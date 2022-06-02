package route

object SafeRoute {
    infix fun Int.fdiv(i: Int): Double = this / i.toDouble();
    fun calcPartialScore(
        totalDistance: Int?,
        distance: Int?,
        roadType: Int?,
        turnType: Int?,
        facilityType : Int?
    ): Double {
        var weight: Double = -1.0
        // case: Point
        if (turnType != null) { return 0.0 }
        // case: LineString

        when (facilityType) {
            1 -> weight = 0.75
            2 -> weight = 0.75
            3 -> weight = 0.75
            12, 14 -> weight = 0.25
            15 -> weight = 0.01
            16 -> weight = 0.75
            17 -> weight = 0.5
            else -> { when (roadType) {
                21-> weight = 1.0
                23-> weight = 0.75
                22, 24 -> weight = 0.25
                else -> { weight = 1.0 }
            }}
        }; return 1.0 / weight * distance!!.fdiv(totalDistance!!)
    } // End of calcPartialScore
}