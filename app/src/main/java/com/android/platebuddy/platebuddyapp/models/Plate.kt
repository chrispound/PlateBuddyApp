package com.android.platebuddy.platebuddyapp.models

import android.os.Parcel
import android.os.Parcelable

data class Plate(val weight: Float, val count: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readFloat(),
        parcel.readInt()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(weight)
        parcel.writeInt(count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Plate> {
        override fun createFromParcel(parcel: Parcel): Plate {
            return Plate(parcel)
        }

        override fun newArray(size: Int): Array<Plate?> {
            return arrayOfNulls(size)
        }
    }
}