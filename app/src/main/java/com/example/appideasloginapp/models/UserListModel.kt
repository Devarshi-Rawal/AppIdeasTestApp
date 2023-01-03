package com.example.appideasloginapp.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class UserListModel {

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var data: ArrayList<Data>? = null

    @SerializedName("code")
    @Expose
    var code: String? = null

    inner class Data{
        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("role")
        @Expose
        var role: Int? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("phone")
        @Expose
        var phone: String? = null

        @SerializedName("photo")
        @Expose
        var photo: Any? = null

        @SerializedName("status")
        @Expose
        var status: String? = null

        @SerializedName("document_status")
        @Expose
        var documentStatus: Any? = null

        @SerializedName("date")
        @Expose
        var date: String? = null

        @SerializedName("month")
        @Expose
        var month: String? = null

        @SerializedName("year")
        @Expose
        var year: String? = null

        @SerializedName("email")
        @Expose
        var email: String? = null

        @SerializedName("email_verified_at")
        @Expose
        var emailVerifiedAt: Any? = null

        @SerializedName("fcm_token")
        @Expose
        var fcmToken: String? = null

        @SerializedName("address")
        @Expose
        var address: Any? = null

        @SerializedName("background")
        @Expose
        var background: String? = null

        @SerializedName("fcm_id")
        @Expose
        var fcmId: Any? = null

        @SerializedName("custom_token")
        @Expose
        var customToken: String? = null

        @SerializedName("google_id")
        @Expose
        var googleId: Any? = null

        @SerializedName("facebook_id")
        @Expose
        var facebookId: Any? = null

        @SerializedName("code")
        @Expose
        var code: String? = null

        @SerializedName("experience")
        @Expose
        var experience: String? = null

        @SerializedName("notification")
        @Expose
        var notification: Int? = null

        @SerializedName("created_at")
        @Expose
        var createdAt: Any? = null

        @SerializedName("updated_at")
        @Expose
        var updatedAt: String? = null

        @SerializedName("doctordetails")
        @Expose
        var doctordetails: List<Doctordetail>? = null
    }

    inner class Doctordetail{
        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("user_id")
        @Expose
        var userId: Int? = null

        @SerializedName("status")
        @Expose
        var status: Any? = null

        @SerializedName("driver_licence")
        @Expose
        var driverLicence: String? = null

        @SerializedName("licence_status")
        @Expose
        var licenceStatus: Any? = null

        @SerializedName("passport")
        @Expose
        var passport: String? = null

        @SerializedName("passport_status")
        @Expose
        var passportStatus: Any? = null

        @SerializedName("created_at")
        @Expose
        var createdAt: String? = null

        @SerializedName("updated_at")
        @Expose
        var updatedAt: String? = null
    }
}