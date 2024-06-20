![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/5087c162-4130-4c54-8c4c-1828fecf9f5d)![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/2279f627-e4ae-4f1b-902d-08fa5db411e6)![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/04b0e4e5-805e-4bcf-8af1-bae9cfe4b13c)# TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM


Troisième Partie : Spring Angular

Objectif : 
Développer une application qui permet de gérer le payement des étudiants. Chaque étudiants peut effectuer plusieurs payements
- Chaque étudiant est défini par son : id, firstName, lastName, email, sa filière, sa photo,
- Chaque Payement est défini par son id, son code, sa date, son type (CASH, CHECK,TRANSFER), son status (CREATED, VALIDATED, REJECTED), file (fichier pdf représentant le reçu de payement)

A: Développer et Tester la partie Backend avec Spring. :
  Voici l'erchitecture generale de l'application : 
  ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/a9ad2159-f2e3-49c8-9bc9-b676e6d76b25)

   1. Créer les entités JPA
          - Entite Payments : 
          ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/a084e8b7-909d-47a0-a4dd-912e0347313d)
          - Entite PaymentStatus :
      ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/8106eb83-8684-480c-a3d4-b66919c58ecf)
 
          - Entite PaymentType :
      ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/3cf23e7f-75dc-466f-a8b3-74bc9628103e)

          - Entite Students :
      ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/3cb454a0-4838-4045-b14a-82fa2803522a)
  
   2. Créer les interfaces JPARepository basées sur Spring Data :
          - interfaces Payments JPARepository  :
      ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/1ac19d7a-8619-43cd-9a58-141bb958bfff)
      
          - interfaces Students JPARepository :
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/59ee33fd-85a8-4d29-b4ab-3bd8d2b828a9)

   3 . Générer des données aléatoires concernant quelques étudiants et pour chaque étudiants des payements : 
   ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/9df9ca36-0efa-4f77-b8a6-362ee68c46cb)
   ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/ec3f755f-34ef-4f2f-aefc-db282815a7d1)
   ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/804dd7c0-52a6-491c-83b5-82e433f585ee)

   4. Créer une Web service RESTful (ResController) qui permet d'exposer les fonctionnalisés suivantes :
        - Consulter tous les payements
        - Consulter un payement sachant son id
        - Consulter les payemenst d'un type donné
        - Consulter les payements d'un status donné
        - Consulter les payements d'un étudiant donné
        - Consulter les payements d'une filière donnée
        - Consulter tous les étudiants
        - Consulter les étudiants d'une filière donnée
        - Consulter un étudiant sachant son code
        - Effectuer un nouveau payement avec les données et le reçu de payement au format pdf
        - Mettre à jour le status d'un payement
        - Consulter le reçu d'un payement  (fichier pdf)

          ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/09435de1-000a-4836-8d82-c6101db68241)
          ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/eeda736c-9a9d-4bed-9d48-563f145e4f8a)
          ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/5cd06198-fc4b-4294-8d68-06ea9dd5beb9)


     5 - Tester le backend en utilisant un client REST (Postman) et avec SWAGGER UI
     afin de faire ajoutyer la dependance d'utlisation swager dans le pom.xml Voici l'inteface quand on a trouvé  : 
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/9540224c-f761-411f-9a0e-d2a18b94626a)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/7a9a2bf2-56b1-414f-bc16-f9c36097c4eb)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/f37d8e9c-b9b5-4eee-bf50-1b5e8da228df)

     6 - Faire un refactoring du code en utilisant la couche service, les DTOs et les Mappers
B : Développer la partie frontend en utilisant Angular avec Angular Material pour la partie design : 
     1. Créer un projet angular
          vérifier si Angular est déjà installé sur votre machine
          
     2. Intégrer Angular Material
      en utilisant le mode commande en tapant : 
              ng add @angular/material
      Avant quand va patiri plus loin voici l'architecture du projet apres la creation du proget angular : 
      ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/32b7bf51-efcf-4e12-9066-71433f775a03)

     3. Créer une page template contenant un Toolbar avec une barre de menu et un Side Menu
  ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/6a6fef9f-e2b5-4741-afa0-b674ba21041b)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/0a9dd6d6-8d13-4446-994c-796b1baf86b3)

![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/314913e2-3814-4d1b-b277-73508bf70e5a)

     4. Créer les différents component de l'application : 
        - admin-template component :
  ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/55a71562-b8d5-4973-9331-f5a6f32c2fec)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/66e7b0de-bd16-46f0-afa7-29d6ed5570be)

![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/1183999a-9d36-4d87-a078-fe3e9b409909)

        - dashboard component :
  ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/6dde98ff-9487-434b-ad66-b85a9cdc9f92)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/f43a3201-72a2-4bc6-8cf7-8f53e8da2517)

        - home component :
  ![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/09970a95-4658-4bc5-b11c-ccebc7d70faa)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/24d1e523-6600-4620-b6e6-7d06a6dd3b07)

        - load-payments component :
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/9f1f1fb7-5ab6-4a10-a528-3013912b5554)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/0aaa559c-3594-406a-9fd9-5e460d2562c7)

        - load-students component :
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/7de6719b-60fc-4477-ab92-9c86eb85ddd7)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/49255983-e0b5-41cc-bc1d-1e8923483ae0)

        - login component :
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/7f8fb15b-a4db-4de5-bb5f-948c1cfc0af5)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/e3d7532f-5c44-4b23-adab-a21cd1564d17)


        - payments component :
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/8c1d9287-f7f0-470c-84ec-2987f685d4de)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/80a0e79c-92ff-4a7c-87aa-e3834001135f)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/75c14b69-aade-4237-bfed-18f96e15bf8c)

        - profile component :
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/a4fa9b2c-d79f-4866-aa47-e827d69f5ae1)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/812631f7-5ff0-4819-b318-9644356b5b58)

        - students component :
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/dc53d042-da23-4a7a-8468-9765c24bdae1)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/3784da9a-e84d-44b9-8980-037f7f2fa91a)

        - app component :
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/e97e5f5f-e3e8-4e9c-b6fb-eaf7cbcd4c52)
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/401a6370-5889-43ab-8eb1-2016efe4537c)

     5. Créer un système d'authentification simple qui oblige l'utilisateur à s'authentifier avant d'accéder à l'application. Dans un premier temps, les utilisateurs et les rôles qui ont le droit d'accéder à l'application sont stockés de manière statique dans le service d'authentification. Protéger les routes par Un Guard d'authentification et un Guard pour les autorisations :
        -  Guard d'authentification (AuthGuard) :
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/873cc7df-9070-4367-a0aa-b1538027689b)

        -  Guard pour les autorisations (AuthorizationGuard) :
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/a1a13a11-92a0-4bc2-9f69-46d7ea1fb736)

  C : Sécurité avec Spring Security et Json Web Token
           - Sécuriser le backend
           - Sécuriser le front end

           Alors pour le back end on fait deja fait ca a l'aide ed Sprinf secutity 

           alors pour le front end :  on va ajouter Service AuthService
           Le service AuthService est une classe Angular utilisée pour gérer l'authentification des utilisateurs dans une
           application.

           Voici c'est ce quand on a fait : 
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/ab9b90b6-88f0-4b80-9a77-dd59fc8440f5)

********************************************************************************************************************************
Voici le resultat des deffirent inteface utliser precidament : 
L'interface Login : 
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/a81d571e-39e4-46ba-8c97-b719a8877e01)

L'interface Admin : 
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/6b023d88-25dd-461c-bb3c-4cb498ffe2c9)

L'interface Home : 
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/a4135467-eaf4-43bd-aaad-3a24aacc086d)

L'interface Profile : 
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/888c45f0-8126-4477-ae35-bc4f0d57bc76)


L'interface Load Students : 
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/513b2445-473a-48eb-8173-64c5140b7998)

L'interface Load Payments : 
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/2503bb35-1125-4bb9-a32e-8fc9955a6f36)

L'interface Dashboard : 
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/db243691-6094-4612-baa0-a640344739da)

L'interface Students : 
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/3a44aa12-e4c0-4c47-9b33-0ba78658fcad)

L'interface Payments : 
![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/8d9c6fb5-d95e-42d7-8668-f39b738bc193)




![image](https://github.com/ayoubbenlahcen/TP4___dernier-partie___Angular---Spring---SD---MIAAD---FSM/assets/152870306/49b1b75b-a988-45a6-9225-660e9b777cf8)
