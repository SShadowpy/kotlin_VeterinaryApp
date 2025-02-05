import com.example.prueba.R
import com.example.prueba.model.ProductModel

class ProductProvider {
    companion object {
        val dogProducts: List<ProductModel> = listOf(
            ProductModel(id = 1, name = "Dog Food", price = 50, imageResourceId = R.drawable.dogfood, description = "Stock dog food", category = "Dog"),
            ProductModel(id = 2, name = "Pooper Scooper", price = 55, imageResourceId = R.drawable.pooperscooper, description = "Tool to pick up pet poop", category = "Dog"),
            ProductModel(id = 3, name = "Pet Leash", price = 85, imageResourceId = R.drawable.flexleash, description = "Standard Pet Leash", category = "Dog"),
            ProductModel(id = 4, name = "Rope toy", price = 99, imageResourceId = R.drawable.biterope, description = "Rope that your dog can chew on!", category = "Dog"),
            ProductModel(id = 5, name = "Lick Mats", price = 330, imageResourceId = R.drawable.retractableleash, description = "Alleviates stress & creates mental stimulation for dogs. Encourages healthy teeth and gums", category = "Dog"),
            ProductModel(id = 6, name = "Flexible Leash", price = 200, imageResourceId = R.drawable.flexibleleash2, description = "Leash that adapts any length", category = "Dog"),
            ProductModel(id = 7, name = "Dog Harness", price = 600, imageResourceId = R.drawable.dogharness1, description = "The most comfortable, adjustable, resistant, no-choke harness", category = "Dog")
        )

       val catProducts: List<ProductModel> = listOf(
            ProductModel(id = 8, name = "Cat Food", price = 50, imageResourceId = R.drawable.catfood, description = "Stock cat food", category = "Cat"),
            ProductModel(id = 9, name = "Cat Snack", price = 20, imageResourceId = R.drawable.cat_snack, description = "Three creamy flavours, purrrfect for treats", category = "Cat"),
            ProductModel(id = 10, name = "Cat Scratcher", price = 300, imageResourceId = R.drawable.cat_scratcher, description = "No more couches destroyed", category = "Cat"),
            ProductModel(id = 11, name = "Catnip Powder", price = 80, imageResourceId = R.drawable.catnip, description = "Entertaining/relaxing toy for cats", category = "Cat"),
            ProductModel(id = 12, name = "Cat leash", price = 150, imageResourceId = R.drawable.catleash, description = "Purrrfect to take a walk", category = "Cat"),
            ProductModel(id = 13, name = "Pooper Scooper", price = 55, imageResourceId = R.drawable.pooperscooper, description = "Tool to pick up pet poop", category = "Cat"),
            ProductModel(id = 26, name = "Window Hammock", price = 250, imageResourceId = R.drawable.windowhammock, description = "A cozy hammock for making your cat feel luxurious", category = "Cat")
        )

        val hamsterProducts: List<ProductModel> = listOf(
            ProductModel(id = 14, name = "Hamster Food", price = 80, imageResourceId = R.drawable.hamsterfood, description = "Keeps your hamster chunky", category = "Hamster"),
            ProductModel(id = 15, name = "Hamster Wheel", price = 120, imageResourceId = R.drawable.hamwheel, description = "Keep your hamster active and healthy", category = "Hamster"),
            ProductModel(id = 16, name = "Water Bottle", price = 80, imageResourceId = R.drawable.waterbottle, description = "Automatically serves water to your fluffy boi", category = "Hamster"),
            ProductModel(id = 17, name = "Car Toy", price = 150, imageResourceId = R.drawable.carwheel, description = "Adds more style to your wheel", category = "Hamster"),
            ProductModel(id = 18, name = "Hamster Cage", price = 300, imageResourceId = R.drawable.hamstercage, description = "A safe place for the hamster", category = "Hamster"),
            ProductModel(id = 19, name = "Cage bedding", price = 80, imageResourceId = R.drawable.petbedding, description = "Make a comfy space for your hamster ", category = "Hamster"),
            ProductModel(id = 27, name = "Hideout Coconut", price = 105, imageResourceId = R.drawable.hideout, description = "Get a safe, comfy and affordable bedroom for your little hamster ", category = "Hamster")

        )
        val bathcareProducts: List<ProductModel> = listOf(
            ProductModel(id = 20, name = "Pet bath", price = 250, imageResourceId = R.drawable.bath, description = "Schedule a bath for your pet", category = "Bath and Care"),
            ProductModel(id = 21, name = "Grooming", price = 300, imageResourceId = R.drawable.grooming, description = "Schedule a session to remove the extra fur and keep your pet with style", category = "Bath and Care"),
            ProductModel(id = 22, name = "Dewormer Pills for Dogs", price = 500, imageResourceId = R.drawable.dogdewormer, description = "Tablets for deworming your dog", category = "Bath and Care"),
            ProductModel(id = 23, name = "Dewormer Pills for Cats", price = 210, imageResourceId = R.drawable.catdewormer, description = "Tablets for deworming your cat", category = "Bath and Care"),
            ProductModel(id = 24, name = "Trim Dog Nails", price = 200, imageResourceId = R.drawable.dognail, description = "Schedule a trimming session for your pet", category = "Bath and Care"),
            ProductModel(id = 25, name = "Trim Cat Claws", price = 200, imageResourceId = R.drawable.catnail, description = "Schedule a trimming session for your pet", category = "Bath and Care"),
        )
    }
}
