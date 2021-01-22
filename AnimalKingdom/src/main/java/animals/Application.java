package animals;

import animals.baseclasses.Animal;
import animals.concreteclasses.GreatWhiteShark;
import animals.concreteclasses.Lion;
import animals.concreteclasses.RobotDog;
import animals.interfaces.IAnimal;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        //animals.baseclasses.Animal someAnimal = new animals.baseclasses.Animal();

        Lion simba = new Lion("Simba");
        GreatWhiteShark jaws = new GreatWhiteShark("Jaws");


        List<IAnimal> allAnimals = new ArrayList<>();
        allAnimals.add( simba );
        allAnimals.add( jaws );

        RobotDog roboSpot = new RobotDog();

        allAnimals.add( roboSpot );

        //we can pass a animals.concreteclasses.Lion to a function that expects an animals.baseclasses.Animal
        //we're trying one "form" as another
        //this is an example "polymorphism" (many forms)
        for( IAnimal toPrint : allAnimals ){
            printAnimalReport( toPrint );
        }

        //cant do this without casting
        //because the compiler doesn't know
        //what we know (that this will be a lion)
        //animals.concreteclasses.Lion retrievedLion = allAnimals.get(0);

        //type casting
        //  this will crash if the cast is invalid
        //  code-smell
        //      typically indicates you made a mistake
        //      when defining a parameter type
        //      or a container type (but not always)
        Lion retrievedLion = (Lion)allAnimals.get(0);


        //can cast primatives too
        long someBigNumber = 5;

        int smallerNum = (int)someBigNumber;


        //this will crash the program
        //animals.concreteclasses.GreatWhiteShark retrievedShark = (animals.concreteclasses.GreatWhiteShark)allAnimals.get(0);




        simba.eatMeat();
        System.out.println(simba.getBloodTemp() );

        //every animals.concreteclasses.Lion is an animal so this is allowed
        //anywhere where an animal is allowed, a animals.concreteclasses.Lion is allowed
        Animal someAnimal = simba;


        //can't do this because we only know (at this point) that
        //someAnimal is an animal and not that they're a carnivore
        //someAnimal.eatMeat();



    }

    public static void printAnimalReport( IAnimal toPrint ){
        System.out.println( toPrint.getName() );

        System.out.println( toPrint.getKingdom() );
        System.out.println( toPrint.getPhylum() );
        System.out.println( toPrint.getAnimalClass() );
        System.out.println( toPrint.getAnimalOrder() );
        System.out.println( toPrint.getFamily() );
        System.out.println( toPrint.getGenus() );
        System.out.println( toPrint.getSpecies() );

    }
}

