package com.atps.bindingClasses;



import java.io.Serializable;



import lombok.Data;

@Data
public class RegistrationSummery {

	private VehicleOwnerDetailsEntity ownerEntity;
	private VehicleOwnerAdressDtlsEntity adressEntity;
	private VehicleDtlsEntity    vehicleEntity;
	private VehiclesRegDtlsEntity regentity;
}
