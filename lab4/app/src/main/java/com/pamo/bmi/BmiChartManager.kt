package com.pamo.bmi

import android.content.Context
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class BmiChartManager(private val chart: LineChart) {

    fun setupChart() {
        val entries = listOf(
            Entry(0f, 24f),
            Entry(1f, 25f),
            Entry(2f, 23f)
        )

        val dataSet = LineDataSet(entries, "BMI")
        val lineData = LineData(dataSet)
        chart.data = lineData
        chart.invalidate()
    }
}
