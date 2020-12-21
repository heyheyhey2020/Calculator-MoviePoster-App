package com.example.cis600_hw2

data class MovieData(
    val popularity: Double,
    val vote_count: Int,
    val video: Boolean,
    val poster_path: String,
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    val genre_ids: List<Int>,
    val title: String,
    val vote_average: Double,
    val overview: String,
    val release_date: String
)

val movies =""" [
    {
      "popularity": 1773.016,
      "vote_count": 1582,
      "video": false,
      "poster_path": "/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg",
      "id": 337401,
      "adult": false,
      "backdrop_path": "/zzWGRw277MNoCs3zhyG3YmYQsXv.jpg",
      "original_language": "en",
      "original_title": "Mulan",
      "genre_ids": [
        28,
        12,
        18,
        14,
        10752
      ],
      "title": "Mulan",
      "vote_average": 7.6,
      "overview": "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential.",
      "release_date": "2020-09-10"
    },
    {
      "popularity": 816.32,
      "vote_count": 206,
      "video": false,
      "poster_path": "/uOw5JD8IlD546feZ6oxbIjvN66P.jpg",
      "id": 718444,
      "adult": false,
      "backdrop_path": "/x4UkhIQuHIJyeeOTdcbZ3t3gBSa.jpg",
      "original_language": "en",
      "original_title": "Rogue",
      "genre_ids": [
        28
      ],
      "title": "Rogue",
      "vote_average": 5.9,
      "overview": "Battle-hardened O’Hara leads a lively mercenary team of soldiers on a daring mission: rescue hostages from their captors in remote Africa. But as the mission goes awry and the team is stranded, O’Hara’s squad must face a bloody, brutal encounter with a gang of rebels.",
      "release_date": "2020-08-20"
    },
    {
      "popularity": 786.374,
      "vote_count": 436,
      "video": false,
      "poster_path": "/sy6DvAu72kjoseZEjocnm2ZZ09i.jpg",
      "id": 581392,
      "adult": false,
      "backdrop_path": "/gEjNlhZhyHeto6Fy5wWy5Uk3A9D.jpg",
      "original_language": "ko",
      "original_title": "반도",
      "genre_ids": [
        28,
        27,
        53
      ],
      "title": "Peninsula",
      "vote_average": 7.2,
      "overview": "A soldier and his team battle hordes of post-apocalyptic zombies in the wastelands of the Korean Peninsula.",
      "release_date": "2020-07-15"
    },
    {
      "popularity": 617.823,
      "vote_count": 1204,
      "video": false,
      "poster_path": "/TnOeov4w0sTtV2gqICqIxVi74V.jpg",
      "id": 605116,
      "adult": false,
      "backdrop_path": "/qVygtf2vU15L2yKS4Ke44U4oMdD.jpg",
      "original_language": "en",
      "original_title": "Project Power",
      "genre_ids": [
        28,
        80,
        878
      ],
      "title": "Project Power",
      "vote_average": 6.7,
      "overview": "An ex-soldier, a teen and a cop collide in New Orleans as they hunt for the source behind a dangerous new pill that grants users temporary superpowers.",
      "release_date": "2020-08-14"
    },
    {
      "popularity": 534.745,
      "vote_count": 269,
      "video": false,
      "poster_path": "/kiX7UYfOpYrMFSAGbI6j1pFkLzQ.jpg",
      "id": 613504,
      "adult": false,
      "backdrop_path": "/r5srC0cqU36n38azFnCyReEksiR.jpg",
      "original_language": "en",
      "original_title": "After We Collided",
      "genre_ids": [
        18,
        10749
      ],
      "title": "After We Collided",
      "vote_average": 6.9,
      "overview": "Tessa finds herself struggling with her complicated relationship with Hardin; she faces a dilemma that could change their lives forever.",
      "release_date": "2020-09-02"
    },
    {
      "popularity": 473.508,
      "vote_count": 271,
      "video": false,
      "poster_path": "/uGhQ2ZGBpzCj6wC5jUrybsZuPTI.jpg",
      "id": 539885,
      "adult": false,
      "backdrop_path": "/dbOqWLNWg1Xphshyus0UMSN8fFP.jpg",
      "original_language": "en",
      "original_title": "Ava",
      "genre_ids": [
        28,
        80,
        18,
        53
      ],
      "title": "Ava",
      "vote_average": 5.9,
      "overview": "A black ops assassin is forced to fight for her own survival after a job goes dangerously wrong.",
      "release_date": "2020-08-06"
    },
    {
      "popularity": 445.55,
      "vote_count": 75,
      "video": false,
      "poster_path": "/eDnHgozW8vfOaLHzfpHluf1GZCW.jpg",
      "id": 606234,
      "adult": false,
      "backdrop_path": "/u9YEh2xVAPVTKoaMNlB5tH6pXkm.jpg",
      "original_language": "en",
      "original_title": "Archive",
      "genre_ids": [
        878
      ],
      "title": "Archive",
      "vote_average": 6.1,
      "overview": "2038: George Almore is working on a true human-equivalent AI, and his latest prototype is almost ready. This sensitive phase is also the riskiest as he has a goal that must be hidden at all costs—being reunited with his dead wife.",
      "release_date": "2020-08-13"
    },
    {
      "popularity": 395.603,
      "vote_count": 144,
      "video": false,
      "poster_path": "/aVbqhqYtlxwEGihTEhewZAgDOCX.jpg",
      "id": 489326,
      "adult": false,
      "backdrop_path": "/dFB6Tiy3z2xRLbnEUB5ocApT5xG.jpg",
      "original_language": "en",
      "original_title": "Mortal",
      "genre_ids": [
        28,
        14,
        53
      ],
      "title": "Mortal",
      "vote_average": 6.8,
      "overview": "A young boy must discover the origins of his extraordinary powers before he is captured by authorities hell-bent on condemning him for an accidental murder.",
      "release_date": "2020-02-28"
    },
    {
      "popularity": 361.329,
      "vote_count": 86,
      "video": false,
      "poster_path": "/sDi6wKgECUjDug2gn4uODSqZ3yC.jpg",
      "id": 632618,
      "adult": false,
      "backdrop_path": "/cVdYaAQmd5DZNdo0KFJruz7JpUs.jpg",
      "original_language": "es",
      "original_title": "Crímenes de familia",
      "genre_ids": [
        80,
        18,
        53
      ],
      "title": "The Crimes That Bind",
      "vote_average": 6.8,
      "overview": "When her son is accused of raping and trying to murder his ex-wife, Alicia embarks on a journey that will change her life forever.",
      "release_date": "2020-08-20"
    },
    {
      "popularity": 348.548,
      "vote_count": 624,
      "video": false,
      "poster_path": "/jHo2M1OiH9Re33jYtUQdfzPeUkx.jpg",
      "id": 385103,
      "adult": false,
      "backdrop_path": "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
      "original_language": "en",
      "original_title": "Scoob!",
      "genre_ids": [
        12,
        16,
        35,
        10751
      ],
      "title": "Scoob!",
      "vote_average": 7.4,
      "overview": "In Scooby-Doo’s greatest adventure yet, see the never-before told story of how lifelong friends Scooby and Shaggy first met and how they joined forces with young detectives Fred, Velma, and Daphne to form the famous Mystery Inc. Now, with hundreds of cases solved, Scooby and the gang face their biggest, toughest mystery ever: an evil plot to unleash the ghost dog Cerberus upon the world. As they race to stop this global “dogpocalypse,” the gang discovers that Scooby has a secret legacy and an epic destiny greater than anyone ever imagined.",
      "release_date": "2020-07-08"
    }
] """.trimIndent()