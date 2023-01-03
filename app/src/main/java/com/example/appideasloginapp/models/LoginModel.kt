package com.example.appideasloginapp.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
class LoginModel {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("code")
    @Expose
    var code: String? = null

    @SerializedName("data")
    @Expose
    var data: Data? = null

    inner class Data{
        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("role")
        @Expose
        var role: Int? = null

        @SerializedName("name")
        @Expose
        var name: Any? = null

        @SerializedName("phone")
        @Expose
        var phone: Any? = null

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
        var date: Any? = null

        @SerializedName("month")
        @Expose
        var month: Any? = null

        @SerializedName("year")
        @Expose
        var year: Any? = null

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
        var background: Any? = null

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
        var experience: Any? = null

        @SerializedName("notification")
        @Expose
        var notification: Int? = null

        @SerializedName("created_at")
        @Expose
        var createdAt: Any? = null

        @SerializedName("updated_at")
        @Expose
        var updatedAt: String? = null
    }
}