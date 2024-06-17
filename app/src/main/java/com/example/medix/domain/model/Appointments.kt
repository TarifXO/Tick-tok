package com.example.medix.domain.model

import com.google.gson.annotations.SerializedName

data class AppointmentRequest(
    val doctorId : Int,
    val patientId : Int,
    val year : Int,
    val month : Int,
    val day : Int,
    val hour : Int,
    val minute : Int
)

data class AppointmentResponse(
    val id: Int,
    val date: Int,
    val time: Int,
    val doctorId: Int,
    val patientId: Int,
    val doctor: String,
    val patient: String
)

data class PatientAppointmentsResponse(
    @SerializedName("appointment_id") val appointmentId: Int,
    @SerializedName("date") val date: String,
    @SerializedName("time") val time: String,
    @SerializedName("doctor_id") val doctorId: Int,
    @SerializedName("doctor_name") val doctorName: String,
    @SerializedName("doctor_phone") val doctorPhone: String,
    @SerializedName("doctor_email") val doctorEmail: String,
    @SerializedName("doctor_speciality") val doctorSpeciality: String,
    @SerializedName("doctor_bio") val doctorBio: String,
    @SerializedName("doctor_address") val doctorAddress: String,
    @SerializedName("doctor_wage") val doctorWage: Int,
    @SerializedName("doctor_Image") val doctorImage: String
)
