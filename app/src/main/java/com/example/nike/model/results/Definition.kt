package com.example.nike.model.results

import java.io.Serializable
import java.util.ArrayList
import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Definition (

    @SerializedName("word")
    @Expose
    var mWord: String?,

    @SerializedName("definition")
    @Expose
    var mDefinition: String?,

    @SerializedName("thumbs_up")
    @Expose
    var mThumbsUp: Int,

    @SerializedName("thumbs_down")
    @Expose
    var mThumbsDown: Int) : Parcelable {

    constructor(parcel: Parcel):
            this(
                parcel.readString(),
                parcel.readString(),
                parcel.readInt(),
                parcel.readInt()
            )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(mWord)
        parcel.writeString(mDefinition)
        parcel.writeInt(mThumbsUp)
        parcel.writeInt(mThumbsDown)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Creator<Definition> {
        override fun createFromParcel(parcel: Parcel): Definition {
            return Definition(parcel)
        }

        override fun newArray(size: Int): Array<Definition?> {
            return arrayOfNulls(size)
        }
    }
}



