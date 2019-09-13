package com.example.nike.model.results

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.Serializable

data class DefinitionList(

    @SerializedName("list")
    @Expose
    var list: List<Definition>?) : Parcelable{

    constructor( parcel: Parcel): this(parcel.createTypedArrayList(Definition))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(list)
    }

    override fun describeContents(): Int {
     return   0
    }



    companion object CREATOR : Parcelable.Creator<DefinitionList> {
        override fun createFromParcel(parcel:Parcel): DefinitionList {
            return DefinitionList(parcel)
        }


        override fun newArray(size: Int): Array<DefinitionList?> {
            return arrayOfNulls(size)
        }

    }


}
