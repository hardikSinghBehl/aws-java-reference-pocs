package com.behl.cipherinator.entity;

import com.behl.cipherinator.utility.Encryptable;

import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

/**
 * Represents a patient's medical record in the Datasource.
 *
 * Fields containing sensitive personal and health information, especially
 * Protected Health Information (PHI), are marked with {@link Encryptable}. This
 * annotation indicates the need for encryption and decryption of these fields
 * using {@link com.behl.cipherinator.utility.FieldEncryptionManager} when
 * storing or retrieving them from the database.
 */
@Setter
@DynamoDbBean
public class MedicalRecord {

	public static final String TABLE_NAME = "MedicalRecords";

	private String id;

	@Encryptable
	private String patientName;

	@Encryptable
	private String medicalHistory;

	@Encryptable
	private String diagnosis;

	@Encryptable
	private String treatmentPlan;

	@Encryptable
	private String allergies;

	private String attendingPhysicianName;

	private String encryptedDataKey;

	@DynamoDbPartitionKey
	@DynamoDbAttribute("Id")
	public String getId() {
		return id;
	}

	@DynamoDbAttribute("PatientName")
	public String getPatientName() {
		return patientName;
	}

	@DynamoDbAttribute("MedicalHistory")
	public String getMedicalHistory() {
		return medicalHistory;
	}

	@DynamoDbAttribute("Diagnosis")
	public String getDiagnosis() {
		return diagnosis;
	}

	@DynamoDbAttribute("TreatmentPlan")
	public String getTreatmentPlan() {
		return treatmentPlan;
	}

	@DynamoDbAttribute("Allergies")
	public String getAllergies() {
		return allergies;
	}

	@DynamoDbAttribute("AttendingPhysicianName")
	public String getAttendingPhysicianName() {
		return attendingPhysicianName;
	}

	@DynamoDbAttribute("EncryptedDataKey")
	public String getEncryptedDataKey() {
		return encryptedDataKey;
	}

}
