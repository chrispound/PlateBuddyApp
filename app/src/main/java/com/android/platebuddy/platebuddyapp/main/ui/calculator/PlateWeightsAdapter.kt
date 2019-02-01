package com.android.platebuddy.platebuddyapp.main.ui.calculator

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.android.platebuddy.platebuddyapp.R
import com.android.platebuddy.platebuddyapp.models.Plate
import java.text.DecimalFormat

class PlateWeightsAdapter: RecyclerView.Adapter<PlateWeightsViewHolder>(){

    val weightFormat = DecimalFormat("##.#")
    var plates: List<Plate> = emptyList()
        set(value) {
            this.notifyDataSetChanged()
            field = value
        }
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PlateWeightsViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_textview_weight, parent, false) as TextView
        return PlateWeightsViewHolder(textView)
    }

    override fun getItemCount(): Int {
        return plates.size
    }

    override fun onBindViewHolder(vh: PlateWeightsViewHolder, position: Int) {
        val plate = plates[position]
        val weightDispaly = weightFormat.format(plate.weight)
        vh.textView.text = vh.itemView.context.getString(R.string.plate_display, plate.count, weightDispaly)
    }

}

class PlateWeightsViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {

}