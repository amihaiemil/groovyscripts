interface Animal {
    void talk();   
}
abstract AbstractAnimal implements Animal {
    String name
    int age
}

abstract Cat extends AbstractAnimal {
    //whatever else a Cat can do besides talking... 
}

// A very lazy, house cat
class HouseCat extends Cat {
    int meowPerHour

    void talk(){
        println "Hello my name is ${name} I am ${age} and I do ${meowPerHour} meow per hour !"
    }
}

interface Garden {
    Cat[] cats(); 
}

class HouseGarden implements Garden {
    private def cats = []
        
    HouseGarden(Cat... cats) {
        this.cats = cats;
    }
}

Garden home = new HouseGarden(
    new Cat(name: "Nuage",age: 3, meowPerHour: 7),
    new Cat(name:"Chamalo", age: 3, meowPerHour: 14)
);

println "In the garden there are ${garden.cats().size()} cats !"
garden.cats().each {cat -> cat.talk()}

//The most important idea in OOP, from my point of view, is to use interfaces for any and all objects,
//and to avoid the concept of "model objects"/JavaBeans. Also, immurability is a very big plus.

