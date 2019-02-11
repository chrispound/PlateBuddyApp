package com.android.platebuddy.platebuddyapp.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Result of the total number of plates needed for the given weight.
 */
data class PlateResult ( val plates: List<Plate>): Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(Plate))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(plates)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlateResult> {
        override fun createFromParcel(parcel: Parcel): PlateResult {
            return PlateResult(parcel)
        }

        override fun newArray(size: Int): Array<PlateResult?> {
            return arrayOfNulls(size)
        }
    }
}