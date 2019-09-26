package be.technocite.oneToOneUni;

import be.technocite.oneToOneUni.maniToOneUni.Journey;
import be.technocite.oneToOneUni.maniToOneUni.Ship;
import be.technocite.oneToOneUni.manyToManyBi.Appointment;
import be.technocite.oneToOneUni.manyToManyBi.Person;
import be.technocite.oneToOneUni.model.oneToOneUni.Address;
import be.technocite.oneToOneUni.model.oneToOneUni.Customer;
import be.technocite.oneToOneUni.oneToMany.Owner;
import be.technocite.oneToOneUni.oneToMany.Phone;
import be.technocite.oneToOneUni.oneToManyBi.Cruise;
import be.technocite.oneToOneUni.oneToManyBi.Reservation;
import be.technocite.oneToOneUni.oneToOneBi.Client;
import be.technocite.oneToOneUni.oneToOneBi.CreditCard;
import be.technocite.oneToOneUni.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

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
	@Autowired
	private JourneyRepository journeyRepository;
	@Autowired
	private ShipRepository shipRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;

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

		//		many to one unidirectionnel Journey * -> Ship
		//Attention ce repository ne respecte pas la méthodologie de l'agragat. Il faudrait pour cela faire
		// du one to many Ship -> * Journey et avoir un shipRepository
		Ship titanic_ii = new Ship("TITANIC II");
		shipRepository.save(titanic_ii);
		journeyRepository.save(new Journey("Viva Carthagena", titanic_ii));
		journeyRepository.save(new Journey("Viva l'Algérie", titanic_ii));

//		many to many bidirectionnel Person * <-> * Appointment
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, Calendar.NOVEMBER, 1);
		Appointment appointment1 = new Appointment(calendar.getTime());
		calendar.set(1994, Calendar.JUNE, 29);
		Appointment appointment2 = new Appointment(calendar.getTime());

		Person person1 = new Person("P1", Arrays.asList(appointment1));
		Person person2 = new Person("P2", Arrays.asList(appointment1, appointment2));
		Person person3 = new Person("P3", Arrays.asList(appointment1, appointment2));

		appointmentRepository.save(appointment1);
		appointmentRepository.save(appointment2);

		personRepository.save(person1);
		personRepository.save(person2);
		personRepository.save(person3);

		System.out.println(personRepository.findByName("P1").get(0).getName());


	}
}
