public class Adapter{

    public static void main(String[] args) {

        FirePokemon charizard = new Charizard();
        WaterPokemon blastoise = new Blastoise();
        PokemonAdapter pokemonAdapter = new FirePokemonAdapter(charizard);
        PokemonAdapter pokemonAdapter2 = new WaterPokemonAdapter(blastoise);
        Pokemon pokemon = new Pokemon(pokemonAdapter2);
        pokemon.primaryAttack();
        pokemon.finalAttack();

    }
}

class Pokemon{
    PokemonAdapter pokemonAdapter;
    Pokemon(PokemonAdapter pokemonAdapter){
        this.pokemonAdapter = pokemonAdapter;
    }

    void primaryAttack(){
        this.pokemonAdapter.primaryAttack();
    }
    void finalAttack(){
        pokemonAdapter.finalAttack();
    }
}
interface FirePokemon{

    public void useFlamethrower();
    public void useOverHeat();
}
class Charizard implements FirePokemon{

    public void useFlamethrower(){
        System.out.println("Charizard used flamethrower");
    }
    public void useOverHeat(){
        System.out.println("Charizard used over heat");
    }

}


interface WaterPokemon{

    public void useDiveAttack();
    public void useSurfAttack();
}
class Blastoise implements WaterPokemon{

    public void useDiveAttack(){
        System.out.println("Blstoise used dive");
    }
    public void useSurfAttack(){
        System.out.println("Blastoise used surf");
    }

}
interface PokemonAdapter{

    public void primaryAttack();
    public void finalAttack();
}

class FirePokemonAdapter implements PokemonAdapter{
    FirePokemon pokemon;
    FirePokemonAdapter(FirePokemon pokemon){
        this.pokemon=pokemon;
    }

    public void primaryAttack(){
        pokemon.useFlamethrower();
    }
    public void finalAttack(){
        pokemon.useOverHeat();
    }


}

class WaterPokemonAdapter implements PokemonAdapter{
    WaterPokemon pokemon;
    WaterPokemonAdapter(WaterPokemon pokemon){
        this.pokemon=pokemon;
    }

    public void primaryAttack(){
        pokemon.useDiveAttack();
    }
    public void finalAttack(){
        pokemon.useSurfAttack();
    }


}