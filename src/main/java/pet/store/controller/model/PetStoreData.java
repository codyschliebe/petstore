package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor

public class PetStoreData {

	private Long petStoreId;
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;

	private Set<PetStoreCustomer> customers = new HashSet<>();
	private Set<PetStoreEmployee> employees = new HashSet<>();

	public PetStoreData(PetStore petStore) {
		petStoreId = petStore.getPetStoreId();
		petStoreName = petStore.getPetStoreName();
		petStoreAddress = petStore.getPetStoreAddress();
		petStoreCity = petStore.getPetStoreCity();
		petStoreState = petStore.getPetStoreState();
		petStoreZip = petStore.getPetStoreZip();
		petStorePhone = petStore.getPetStorePhone();

		for (Employee employee : petStore.getEmployees()) {
			employees.add(new PetStoreEmployee(employee));
		}

		for (Customer customer : petStore.getCustomers()) {
			customers.add(new PetStoreCustomer(customer));
		}
		employees = getEmployees();
	}

	@Data
	@NoArgsConstructor
	public static class PetStoreCustomer {
		private Long customerId;
		private String customerFirstName;
		private String customerLastName;
		private String customerEmail;

		public PetStoreCustomer(Customer customer) {
			customerId = getCustomerId();
			customerFirstName = getCustomerFirstName();
			customerLastName = getCustomerLastName();
			customerEmail = getCustomerEmail();
		}
	}

	@Data
	@NoArgsConstructor
	public static class PetStoreEmployee {
		private Long employeeId;
		private String employeeFirstName;
		private String employeeLastName;
		private String employeePhone;
		private String employeeJobTitle;

		public PetStoreEmployee(Employee employee) {
			employeeId = getEmployeeId();
			employeeFirstName = getEmployeeFirstName();
			employeeLastName = getEmployeeLastName();
			employeePhone = getEmployeePhone();
			employeeJobTitle = getEmployeeJobTitle();
		}
	}

}