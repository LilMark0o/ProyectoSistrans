# Description: This file contains the data used in the project.

first_names = list({
    "Adriana", "Cristiano", "Maria", "Juan", "Lucia", "David", "Elena", "Carlos", "Ana", "Miguel",
    "Paula", "Jose", "Julia", "Javier", "Alba", "Daniel", "Sara", "Pablo", "Laura", "Manuel",
    "Claudia", "Alejandro", "Emma", "Alvaro", "Valeria", "Jorge", "Martina", "Alberto", "Sofia", "Raul",
    "Valentina", "Sergio", "Julia", "Fernando", "Camila", "Ricardo", "Noa", "Diego", "Lola", "Antonio",
    "Isabel", "Fernando", "Teresa", "Antonio", "Sofia", "Ricardo", "Beatriz", "Rafael", "Laura", "Daniel",
    "Carmen", "Manuel", "Rosa", "Jose", "Gabriela", "Victor", "Luisa", "Jorge", "Martha", "Roberto",
    "Silvia", "Hector", "Monica", "Alberto", "Patricia", "Pedro", "Alejandra", "Andres", "Susana", "Eduardo",
    "Natalia", "Oscar", "Sara", "Sergio", "Camila", "Ruben", "Cecilia", "Ernesto", "Luz", "Ramon",
    "Ines", "Raul", "Isabel", "Francisco", "Eva", "Raul", "Ines", "Miguel", "Cristina", "Juan",
    "Rocio", "Luis", "Celia", "Luis", "Rocio", "Javier", "Celia", "Jesus", "Elena", "Javier",
    "Andrea", "Ignacio", "Liliana", "Mauricio", "Diana", "Samuel", "Norma", "Francisco", "Yolanda", "Arturo",
    "Veronica", "Julio", "Isaac", "Bianca", "Claudia", "Diego", "Emma", "Jaime", "Karla", "Pablo",
    "Catalina", "Javier", "Daniela", "Erick", "Valeria", "Mario", "Estefania", "Felix", "Patricia", "Agustin",
    "Lorena", "Alfredo", "Carolina", "Marco", "Paola", "Martin", "Marcela", "Salvador", "Mariana", "Alfonso",
     "Alvaro", "Julia", "Armando", "Alicia", "Benito", "Claudia", "Cesar", "Eva", "Cristobal",
    "Gabriel", "Elena", "Gustavo", "Ines", "Hugo", "Irene", "Joaquin", "Leticia", "Lorenzo",
    "Lidia", "Luis", "Lourdes", "Marcos", "Marta", "Mariano", "Mercedes", "Miguel Angel", "Nuria",
    "Nicolas", "Olga", "Paco", "Pilar", "Raul", "Raquel", "Raul", "Rocio", "Rodrigo",
    "Rosa Maria", "Santiago", "Sonia", "Simon", "Susana", "Tomas", "Teresa", "Vicente", "Vanesa",
    "Vicente", "Violeta", "Xavier", "Yolanda", "Zacarias", "Zoe", "Zulema", "Zoraida", "Zaida",
    "Zaira", "Zita", "Zoe", "Zorion", "Zuriñe", "Zigor", "Zelai", "Zigor", "Zelai",
    "Marco", "Nate", "Justin", "Ethan", "Dylan", "Carter", "Brandon", "Kayden", "Chase",
    "Jonathan", "Sebastian", "Blake", "Jace", "Tyler", "Gavin", "Landon", "Mason", "Lucas",
    "Jacob", "Jackson", "Aiden", "Logan", "Jack", "Jayden", "Ryan", "Matthew", "Noah",
    "Michael", "Elijah", "James", "Benjamin", "William", "Alexander", "Oliver", "Connor", "Daniel",
    "Gabriel", "Henry", "Carter", "Matthew", "Ryan", "Jacob", "Luke", "Jack", "Michael",
    "William", "James", "Ethan", "Alexander", "Daniel", "Matthew", "Aiden", "Henry", "Joseph",

})

last_names = list({
    "Mendoza", "Ronaldo", "Garcia", "Lopez", "Fernandez", "Martinez", "Rodriguez", "Sanchez", "Perez", "Diaz",
    "Gomez", "Vazquez", "Castro", "Jimenez", "Ruiz", "Hernandez", "Dominguez", "Gutierrez", "Gonzalez", "Serrano",
    "Blanco", "Muñoz", "Santos", "Flores", "Ortega", "Alvarez", "Morales", "Ramirez", "Rubio", "Martin",
    "Delgado", "Suarez", "Medina", "Ortiz", "Cortes", "Castillo", "Garrido", "Castillo", "Garrido", "Castillo",
    "Gonzalez", "Herrera", "Castro", "Ramirez", "Aguilar", "Ruiz", "Vargas", "Torres", "Reyes", "Guerrero",
    "Cruz", "Ortiz", "Mendez", "Vega", "Rios", "Delgado", "Romero", "Morales", "Alvarez", "Moreno",
    "Molina", "Castillo", "Jimenez", "Hernandez", "Flores", "Valdez", "Guerra", "Dominguez", "Contreras", "Salazar",
    "Navarro", "Pena", "Campos", "Avila", "Cortez", "Vasquez", "Rojas", "Soto", "Freitas", "Espinoza",
    "Valencia", "Arroyo", "Paredes", "Cordero", "Trejo", "Urbina", "Villanueva", "Bautista", "Franco", "Merino",
    "Carrillo", "Cabrera", "Guzman", "Gutierrez", "Escobar", "Chavez", "Mora", "Arias", "Aguirre", "Santos",
    "Silva", "Castaneda", "Montes", "Luna", "Maldonado", "Juarez", "Cervantes", "Ibarra", "Rocha", "Orozco",
    "Carranza", "Cisneros", "Cuevas", "Villarreal", "Cruz", "Villalobos", "Santana", "Valenzuela", "Lara", "Villanueva",
    "Villalpando", "Villagomez", "Villalva", "Villalba", "Villalpando", "Villagomez", "Villalva", "Villalba", "Villalpando",
    "Jackson", "Ford", "Oppenheimer", "Gates", "Buffett", "Musk", "Bezos", "Zuckerberg", "Ellison", "Page",
    "Brin", "Walton", "Arnault", "Slim", "Koch", "Koch", "Albrecht", "Albrecht", "Kamprad",
    "Kamprad", "Muller", "Muller", "Beate", "Beate", "Beate", "Beate", "Beate", "Beate",
    "Nietzsche", "Schopenhauer", "Kant", "Hegel", "Hume", "Locke", "Descartes", "Aristotle", "Plato", "Socrates",
    "Confucius", "Lao Tzu", "Machiavelli", "Montaigne", "Rousseau", "Voltaire", "Marx", "Engels", "Smith",
    "Darwin", "Freud", "Einstein", "Curie", "Galilei", "Newton", "Hawking", "Bohr", "Heisenberg",
    "Planck", "Schrodinger", "Feynman", "Pauli", "Gell-Mann", "Dirac", "Higgs", "Gauss", "Riemann", "Euler",
    "Poincare", "Hilbert", "Cantor", "Turing", "Godel", "Peano", "Russell", "Babbage", "Von Neumann", "Padua"

})


tipousuario_data = ["Administrador", "Gerente", "Recepcionista", "Cliente", "Empleado"]

# Hotels 
adjectives = ["Grand", "Royal", "Luxury", "Elegant", "Majestic", "Prestige", "Regal", "Golden", "Classic", "Serene"]
names = ["Palace", "Resort", "Suites", "Inn", "Lodge", "Manor", "Villa", "Chalet", "Retreat", "Haven"]

# Rooms spanish
room_types = ["Individual", "Doble", "Triple", "Suite", "Suite Junior", "Suite Presidencial", "Suite Real", "Suite Imperial"]

# Create a dictionary with the room types with the price per night
room_types_prices = {
    "Individual": 50000,
    "Doble": 75000,
    "Triple": 100000,
    "Suite": 150000,
    "Suite Junior": 200000,
    "Suite Presidencial": 250000,
    "Suite Real": 300000,
    "Suite Imperial": 350000
}

# Define service names that are coherent with each table
service_names_for_tables = {
    "bar": ["Bar Access", "Premium Bar", "Rooftop Bar", "Lounge Bar", "Exclusive Bar",
            "Kids Bar", "Pool Bar", "Beach Bar", "Cocktail Bar", "Wine Bar", "Beer Bar",
            "Champagne Bar", "Juice Bar", "Snack Bar", "Coffee Bar", "Tea Bar", "Sports Bar",
            "Karaoke Bar", "Disco Bar", "Night Bar", "Pub", "Cafeteria", "Restaurant Bar",
            "Buffet Bar", "Open Bar", "Barbecue Bar", "Barbecue", "Barbecue Grill", "Barbecue Lounge",
             "Barbecue Club", "Barbecue Disco", "Barbecue Night", "Barbecue Party",
             "Barbecue Restaurant", "Barbecue Buffet", "Barbecue Pub"],
    "gimnasio": ["Gym Access", "Fitness Center", "Health Club", "Workout Room", "Training Center",
                 "Exercise Room", "Fitness Room", "Gymnasium", "Gym Lounge", "Gym Club", "Gym Disco",
                 "Gym Night", "Gym Party", "Gym Restaurant", "Gym Buffet", "Gym Pub", "Spinnging Room",
                 "Muscle Room", "Cardio Room", "Yoga Room", "Pilates Room", "Zumba Room", "Crossfit Room",
                 "Calisthenics Room", "Aerobics Room", "Bodybuilding Room", "Weightlifting Room",
                 "Powerlifting Room", "Bodypump Room", "Bodycombat Room", "Bodybalance Room",
                 "Bodyattack Room", "Bodyjam Room", "Bodystep Room", "Bodyvive Room", "Cxworx Room",
                 "Rpm Room", "Shbam Room", "Les Mills Room", "Les Mills Grit Room", "Les Mills Sprint Room",
                 "Boxing Room", "Kickboxing Room", "Martial Arts Room", "Karate Room", "Judo Room",
                 "Taekwondo Room", "Muay Thai Room", "Kung Fu Room", "Jiu Jitsu Room", "Wrestling Room",
                 "Grappling Room", "Sambo Room", "Aikido Room", "Capoeira Room", "Krav Maga Room"],
    "internet": ["Premium Wi-Fi", "High-Speed Internet", "Business Internet", "Internet Lounge",
                 "10 mbps Internet", "20 mbps Internet", "30 mbps Internet", "40 mbps Internet", "50 mbps Internet",
                 "60 mbps Internet", "70 mbps Internet", "80 mbps Internet", "90 mbps Internet", "100 mbps Internet",
                 "110 mbps Internet", "120 mbps Internet", "130 mbps Internet", "140 mbps Internet", "150 mbps Internet",
                 "160 mbps Internet", "170 mbps Internet", "180 mbps Internet", "190 mbps Internet", "200 mbps Internet",
                 "210 mbps Internet", "220 mbps Internet", "230 mbps Internet", "240 mbps Internet", "250 mbps Internet",
                 "260 mbps Internet", "270 mbps Internet", "280 mbps Internet", "290 mbps Internet", "300 mbps Internet",
                 "310 mbps Internet", "320 mbps Internet", "330 mbps Internet", "340 mbps Internet", "350 mbps Internet",
                 "360 mbps Internet", "370 mbps Internet", "380 mbps Internet", "390 mbps Internet", "400 mbps Internet",
                 "410 mbps Internet", "420 mbps Internet", "430 mbps Internet", "440 mbps Internet", "450 mbps Internet",
                 "460 mbps Internet", "470 mbps Internet", "480 mbps Internet", "490 mbps Internet", "500 mbps Internet",
                 "510 mbps Internet", "520 mbps Internet", "530 mbps Internet", "540 mbps Internet", "550 mbps Internet",
                 "560 mbps Internet", "570 mbps Internet", "580 mbps Internet", "590 mbps Internet", "600 mbps Internet",
                 "610 mbps Internet", "620 mbps Internet", "630 mbps Internet", "640 mbps Internet", "650 mbps Internet",
                 "660 mbps Internet", "670 mbps Internet", "680 mbps Internet", "690 mbps Internet", "700 mbps Internet",
                 "710 mbps Internet", "720 mbps Internet", "730 mbps Internet", "740 mbps Internet", "750 mbps Internet",
                 "760 mbps Internet", "770 mbps Internet", "780 mbps Internet", "790 mbps Internet", "800 mbps Internet",
                 "810 mbps Internet", "820 mbps Internet", "830 mbps Internet", "840 mbps Internet", "850 mbps Internet",
                 "860 mbps Internet", "870 mbps Internet", "880 mbps Internet", "890 mbps Internet", "900 mbps Internet",
                 "910 mbps Internet", "920 mbps Internet", "930 mbps Internet", "940 mbps Internet", "950 mbps Internet",
                 "960 mbps Internet", "970 mbps Internet", "980 mbps Internet", "990 mbps Internet", "1000 mbps Internet",],
    "lavado": ["Laundry Service", "Dry Cleaning", "Express Laundry", "Clothes Pressing", "Deluxe Laundry", 
               "Ironing Service", "Washing Service", "Washing Machine", "Dryer", "Washing Machine and Dryer", 
               "Washing Machine and Dryer Service", "Washing Machine and Dryer Access", "Washing Machine and Dryer Lounge",
               "Shoe Cleaning", "Shoe Polishing", "Shoe Repair", "Shoe Service", "Shoe Access", "Shirt Cleaning",
               "Shirt Pressing", "Shirt Ironing", "Shirt Service", "Shirt Access", "Suit Cleaning", "Suit Pressing",
               "Suit Ironing", "Suit Service", "Suit Access", "Dress Cleaning", "Dress Pressing", "Dress Ironing",
               "Dress Service", "Dress Access", "Skirt Cleaning", "Skirt Pressing", "Skirt Ironing", "Skirt Service",
               "Skirt Access", "Pants Cleaning", "Pants Pressing", "Pants Ironing", "Pants Service", "Pants Access",
               "Jeans Cleaning", "Jeans Pressing", "Jeans Ironing", "Jeans Service", "Jeans Access", "Trousers Cleaning",
                "Trousers Pressing", "Trousers Ironing", "Trousers Service", "Trousers Access", "Shorts Cleaning",
                "Shorts Pressing", "Shorts Ironing", "Shorts Service", "Shorts Access", "Blouse Cleaning", "Blouse Pressing",
                "Blouse Ironing", "Blouse Service", "Blouse Access", "T-Shirt Cleaning", "T-Shirt Pressing", "T-Shirt Ironing",
                "T-Shirt Service", "T-Shirt Access", "Sweater Cleaning", "Sweater Pressing", "Sweater Ironing", "Sweater Service",
                "Sweater Access", "Sweatshirt Cleaning", "Sweatshirt Pressing", "Sweatshirt Ironing", "Sweatshirt Service"],
    "piscina": ["Swimming Pool", "Rooftop Pool", "Indoor Pool", "Heated Pool", "Olympic Pool", "Infinity Pool",
                "Beach Pool", "Kids Pool", "Jacuzzi", "Hot Tub", "Sauna", "Steam Room", "Spa Pool", "Spa Jacuzzi",
                "20 meters Pool", "25 meters Pool", "30 meters Pool", "35 meters Pool", "40 meters Pool", "45 meters Pool",
                "50 meters Pool", "55 meters Pool", "60 meters Pool", "65 meters Pool", "70 meters Pool", "75 meters Pool",
                "80 meters Pool", "85 meters Pool", "90 meters Pool", "95 meters Pool", "100 meters Pool", "105 meters Pool",],
    "prestamo": ["Loan Service", "Equipment Loan", "Valet Service", "Special Loan", "Device Loan", 
                "Gadget Loan", "Electronic Loan", "Electronic Device Loan", "Electronic Equipment Loan", "Towel Loan",
                "Beach Towel Loan", "Pool Towel Loan", "Bath Towel Loan", "Bathrobe Loan", "Swimsuit Loan", "Bikini Loan",
                "Swimming Trunks Loan", "Flip Flops Loan", "Beach Umbrella Loan", "Beach Chair Loan", "Beach Ball Loan",
                "Beach Mat Loan", "Beach Bag Loan", "Beach Accessory Loan", "Beach Equipment Loan", "Pool Accessory Loan",
                "Pool Equipment Loan", "Pool Accessory Loan", "Pool Equipment Loan", "Pool Accessory Loan", "Pool Equipment Loan"],
    "restaurante": ["Restaurant Booking", "Dining Reservation", "Exclusive Dining", "Buffet Reservation", "Special Dining",
                    "Oriental Restaurant", "Asian Restaurant", "Chinese Restaurant", "Japanese Restaurant", "Korean Restaurant",
                    "Thai Restaurant", "Indian Restaurant", "Vietnamese Restaurant", "Indonesian Restaurant", "Malaysian Restaurant",
                    "Filipino Restaurant", "Mongolian Restaurant", "Singaporean Restaurant", "Taiwanese Restaurant", "Turkish Restaurant",
                    "Arabic Restaurant", "Lebanese Restaurant", "Iranian Restaurant", "Israeli Restaurant", "Afghan Restaurant",
                    "African Restaurant", "Moroccan Restaurant", "Egyptian Restaurant", "Ethiopian Restaurant", "Nigerian Restaurant",
                    "South African Restaurant", "American Restaurant", "Canadian Restaurant", "Mexican Restaurant", "Brazilian Restaurant",
                    "Argentinian Restaurant", "Peruvian Restaurant", "Chilean Restaurant", "Colombian Restaurant", "Venezuelan Restaurant",
                    "European Restaurant", "Spanish Restaurant", "French Restaurant", "Italian Restaurant", "German Restaurant",],
    "spa": ["Spa Treatment", "Massage Service", "Relaxation Spa", "Therapeutic Spa", "Deluxe Spa",
           "Good Hands Spa", "Satisfaction Spa", "Sky Spa", "Heaven Spa", "Heavenly Spa", "Heavenly Hands Spa",
           "Dream Spa", "Dream Hands Spa", "Dreamy Spa", "Dreamy Hands Spa", "Dreamy Sky Spa", "Dreamy Sky Hands Spa",
           "Only one Spa", "Chill Spa", "Chill out Spa", "Chilling Spa"
            ],
    "tienda": ["Shop Access", "Exclusive Shop", "Gift Shop", "Minimarket", "Deluxe Store", 
                "Luxury Store", "Jeans Store", "Shoes Store", "Clothes Store", "Fashion Store",
                "Jewelry Store", "Watch Store", "Perfume Store", "Cosmetics Store", "Makeup Store",
                "Sunglasses Store", "Electronics Store", "Computer Store", "Phone Store", "Tablet Store",
                "Laptop Store", "Camera Store", "Video Camera Store", "Headphones Store", "Speaker Store",
                "TV Store", "Home Theater Store", "Video Game Store", "Console Store", "Game Store",
                "Toy Store", "Board Game Store", "Puzzle Store", "Card Game Store", "Book Store",
                "Magazine Store", "Newspaper Store", "Comic Store", "Sports Store", "Sport Store",
                "Sporting Goods Store", "Sportswear Store", "Sport Shoes Store", "Sport Clothes Store",]
}

# Product restaurant names and bar names
product_names_drink = ["Coca-Cola", "Pepsi", "Fanta", "Sprite", "7up", "Mirinda", "Dr Pepper", "Mountain Dew", "Schweppes", "Canada Dry",
                 "Coca-Cola Light", "Coca-Cola Zero", "Pepsi Light", "Pepsi Max", "Fanta Light", "Fanta Zero", "Sprite Light", "Sprite Zero",
                 "7up Light", "7up Zero", "Mirinda Light", "Mirinda Zero", "Dr Pepper Light", "Dr Pepper Zero", "Mountain Dew Light", "Mountain Dew Zero",
                 "Schweppes Light", "Schweppes Zero", "Canada Dry Light", "Canada Dry Zero", "Coca-Cola Cherry", "Pepsi Cherry", "Fanta Cherry",
                 "Sprite Cherry", "7up Cherry", "Mirinda Cherry", "Dr Pepper Cherry", "Mountain Dew Cherry", "Schweppes Cherry", "Canada Dry Cherry",
                 "Coca-Cola Cherry Light", "Pepsi Cherry Light", "Fanta Cherry Light", "Sprite Cherry Light", "7up Cherry Light", "Mirinda Cherry Light",
                 "Dr Pepper Cherry Light", "Mountain Dew Cherry Light", "Schweppes Cherry Light", "Canada Dry Cherry Light", "Coca-Cola Cherry Zero",
                 "Pepsi Cherry Zero", "Fanta Cherry Zero", "Sprite Cherry Zero", "7up Cherry Zero", "Mirinda Cherry Zero", "Dr Pepper Cherry Zero",
                 "Mountain Dew Cherry Zero", "Schweppes Cherry Zero", "Canada Dry Cherry Zero", "Coca-Cola Vanilla", "Pepsie Vanilla", "Fanta Vanilla",
                    "Sprite Vanilla", "7up Vanilla", "Mirinda Vanilla", "Dr Pepper Vanilla", "Mountain Dew Vanilla", "Schweppes Vanilla", "Canada Dry Vanilla",
                    "Coca-Cola Vanilla Light", "Pepsi Vanilla Light", "Fanta Vanilla Light", "Sprite Vanilla Light", "7up Vanilla Light", "Mirinda Vanilla Light",]

product_name_restaurant_food = ["Hamburger", "Cheeseburger", "Double Cheeseburger", "Bacon Cheeseburger", "Bacon Double Cheeseburger", "Big Mac",
                "Sushi", "Sashimi", "Maki", "Nigiri", "Uramaki", "Temaki", "California Roll", "Philadelphia Roll", "Spicy Tuna Roll",
                "Tuna Roll", "Salmon Roll", "Salmon Avocado Roll", "Avocado Roll", "Cucumber Roll", "Shrimp Tempura Roll", "Shrimp Roll",
                "Bandeja paisa", "Ajiaco", "Sancocho", "Bandeja de huevo", "Bandeja de lomo", "Bandeja de pollo", "Bandeja de carne",
                "Bandeja de chicharron", "Bandeja de pescado", "Bandeja de cerdo", "Bandeja de pavo", "Bandeja de res", "Bandeja de ternera",
                "Pizza", "Pepperoni Pizza", "Hawaiian Pizza", "Margarita Pizza", "Meat Lovers Pizza", "Vegetarian Pizza", "Cheese Pizza",
                "Chicken Pizza", "Seafood Pizza", "BBQ Chicken Pizza", "Buffalo Chicken Pizza", "Chicken Bacon Ranch Pizza", "Chicken Alfredo Pizza",
                "Diablo Pizza", "Supreme Pizza", "Veggie Supreme Pizza", "Veggie Pizza", "Veggie Lovers Pizza", "Veggie Delight Pizza",
                "Onigiri", "Ramen", "Udon", "Soba", "Yakisoba", "Yakitori", "Yakiniku", "Okonomiyaki", "Takoyaki", "Sukiyaki", "Sashimi",
                "Arroz con pollo", "Arroz con mariscos", "Arroz con camarones", "Arroz con verduras", "Arroz con carne", "Arroz con pollo y verduras",
                "Arroz con pollo y camarones", "Arroz con pollo y carne", "Arroz con mariscos y verduras", "Arroz con mariscos y camarones",
                "Arroz con mariscos y carne", "Arroz con camarones y verduras", "Arroz con camarones y carne", "Arroz con verduras y carne",
                "Arroz con pollo, verduras y camarones", "Arroz con pollo, verduras y carne", "Arroz con pollo, camarones y carne",
]


spa_product_names = ["Massage", "Relaxation Massage", "Therapeutic Massage", "Deluxe Massage", "Good Hands Massage", "Satisfaction Massage",
                    "Skin Treatment", "Facial Treatment", "Skin Care Treatment", "Skin Care", "Facial Care", "Facial", "Skin Care",
                    "Sauna Treatment", "Steam Treatment", "Spa Treatment"]






    