package be.technocite.oneToOneUni;

import be.technocite.oneToOneUni.model.oneToOneUni.Address;
import be.technocite.oneToOneUni.model.oneToOneUni.Customer;
import be.technocite.oneToOneUni.oneToMany.Owner;
import be.technocite.oneToOneUni.oneToMany.Phone;
import be.technocite.oneToOneUni.oneToManyBi.Cruise;
import be.technocite.oneToOneUni.oneToManyBi.Reservation;
import be.technocite.oneToOneUni.oneToOneBi.Client;
import be.technocite.oneToOneUni.oneToOneBi.CreditCard;
import be.technocite.oneToOneUni.repository.ClientRepository;
import be.technocite.oneToOneUni.repository.CruiseRepository;
import be.technocite.oneToOneUni.repository.CustomerRepository;
import be.technocite.oneToOneUni.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class OneToOneUniApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private CruiseRepository cruiseRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneUniApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello world");

//		one to one unidirectionnel Customer -> Address
		customerRepository.save(new Customer(new Address("rue des petits poids", 1)));
//		one to one bidirectionnel Client <-> CreditCard
		clientRepository.save(new Client(new CreditCard(150)));
//		one to many unidirectionnal Owner -> * Phone
		Phone[] nokias = {new Phone("NOKIA"), new Phone("BLACKBERRY"), new Phone("MOTOROLA")};
		Owner owner = new Owner(new ArrayList<Phone>(Arrays.asList(nokias)));
		ownerRepository.save(owner);
//		many to one bidirectionnel Cruise <-> * Reservation
		Reservation[] reservations = {new Reservation(49), new Reservation(55557)};
		cruiseRepository.save(new Cruise("Alexandrie", Arrays.asList(reservations)));
	}
}
