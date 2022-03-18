package com.aghogho.movieapp.widgets

//Pass Information along when you navigate from HomeScreen to DetailScreen.
//We have the navGraph setup for DetailScreen. If we want to pass the title of movie in
//HomeScreen to DetailScreen, when the Card in HomeScreen is clicked, we pass an argument,
//and its type. To get the information
//How do we retrive the information from current route and pass it along to the next route when
//a click event happen ? We have access to NavBackStackEntry in the composable lambda. The inherent
//variable contains the information we want, we can pass that variable into DetailScreen. I named
//the variable here as backStackEntry.
//Fix too many argument for DetailScreen, by passing a var of type String as parameter, because
//DetailScreen will now be expecting a String parameter passed into it.
//Now go to DetailScreen and pass into the Text the data that should be captured, the data is now
//stored in movieData var.
//Now go to HomeScreen where and also pass in the data there because this is the screen we are
//navigating from to DetailScreen. In the MovieRow , within the lambda, define a var, call it
// passMovieContent. And concatenate this var to the route in the navController.navigate.
//This is basically passing the argument (passMovieContent) into the route.
//The idea is to be able to pass loads of info from an object. Imagine if the movie is an object
//from some API, we can pass the id of a specific object, once the id of movie clicked matches an
//id from the data source, get that particular movie and get as much key value pair you want from
//there and display in your application.

//Display the content that is passed along when navigating properly.
//In DatialScreen file, create a Surface, Create a Column within Surface. Put the Text into
// the Column and apply proper modifiers and styles.

//Create Back Button from DetailScreen.
//We want to be able to go back to the previous screen/composable which is HomeScreen. As we
//navigate we do have a stack. To go back we need to pop the Screen which is on top of the screen
//we navigating from. Within the onClick, put there navController.popBackStack.

//Add TopNavBar and back button when we navigate to DetailScreen.
//Notice that when we navigate to DetailScreen, we loose the TopNavBar. We want to add that and
//also a back btn

//Add Movie Data in data class
//Represent each movie as an object. The data is presented locally in the fun getMovies defined
//in our MovieData data class. This fun getMovies returns a List of movie object. Each movie has
//an id, title, year, genre properties. etc. This is what I will use to populate my UI.
//Go to HomeScreen, the fun MainContent, where we have initially defined Movies as List of Strings, and change that to
//List<Movies> = getMovies()
//We will have an error because MovieRow is expecting a String, but we have changed the String values
//to the data class list MovieData. Go to MovieRow composable, and change movie type parameter from
//String to MovieData object. MovieRow composable is defined in MainActivity.
//We will have an error within the onClick in MovieRow. This is also because the movie parameter
//will now be expecting a MovieData but has still a String. Get the id of the movie when it is
//clicked. movie.id
//We will still have an error on the Text. This is because the Text now which initially displays a
//movie string, should now display a movie that is an object. So we can just put there movie.title
//Basically invoking the properties of our object.
//Create a package called widgets, where we will add pieces of the UI i.e smaller composable.
//Refactor MovieRow into widgets package.
//At the moment upon clicking each movie from HomeScreen, we get navigated to DetailScreen and
//display the id of that particular movie. We are displaying the id because that is what I set in
//MovieRow in Widgets file when a Movie is clicked.
//Recall our MovieData class has images which is a listOf image url.
//in MovieRow within Widgets file, set the parameter movie to getMovies()[0], to get the MovieData.
//The step above is to get rid of error that occurs when the annotated with @Preview. We just get
//the first item in the MovieData list.
//Still within MovieRow, we want to get the data and display them on the UI. Create a Column so
//we can display the data in vertical format. Just getting the property of the MovieData object.
//We get the title, director and year of released

//Coil Library
//Now we will get the images from the data class and display them on the UI.
//We use the Coil library to get url images in compose. Coil is a libaray that allow us to get images
//from url. Add the library dependency. Coil takes care of memory issue.
//The first image from each image object that we are using as poster image will be added now to
// each of the cards.
//Still in the Widgets file and in MovieRow composable, use coil to get Image. use the image that
//contains the object from the data class. movies.images[0] and set internet permission in manifest.
//With Coil, we can invoke Builder to add animation effects and transformation of image to different
//shape e.g to circle etc.

//Add a chevron arrow that when clicked it expands the card to show more content and when collapsed it
//collapses the card. Still in Widgets add a new Icon that will hold additional image obj prop.
//In the modifier add clickable for obvious reason.
//When we click the down chevron arrow, I want to increase the size of the row, and when its clicked
//again, I want to reduce the size of the row. To get this done. Right after the Text where I have
//Released, I will add a Column. This Column will hold the information that is going to be hidden
//by default. I want to make sure that we have a variable or a state that will know whether the
//chevron arrow is clicked or not. If its clicked we show the Column and its content, if its not
//we collapse it. Create a val at the top of the class called toggleChevronArrow by remember...
//Now that we have the var that will control the state, we will now call it in the Chevron Icon
//clickable by toggling it to its opposite.
//Now to be able to effect this is the Column, we wrap the Column in compose fun called
//AnimatedVisibility and pass in the var as a boolean into visible.
//If you notice the Card has fixed height, we want to make the height of the card to be dynamic
//depending on the size of the contents that should be on it. Comment out the height in the Card.
//In the AnimatedVisibility, within the Column, use the Text AnnotatedString. Pass buildAnnotatedString
//lambda. This allows us to be able to change individual strings that we want to show.

//This is very important. How do you get the information about the movie once a movie is clicked
//to redirect you to detail screen. At the moment we are only getting the id of the particular movie
//in DetailScreen once a movie is clicked from the HomeScreen.
//Filter through the List of movies until you find an Id that contain the id of the movie that we
//clicked. movieData here is a String. movieData could as well be the id i.e movieId.
//Create a variable newMovieList inside the lambda of DetailScreen, set the variable to getMovies() and
//pass in the filter method onto it. Filter return a list containing those Type. With this we
//should have at least one movie that will match the id we are passing.
//Now in the Text where I originally passed movieData.toString to get movie id, change that to
// newMovieList, because I do not just want to display just movie id. I used the movieData.id
// to get the id of that specific movie to get its content. Get the first index. It makes sense
//because we should get one item that is found during the filter process.

//Since we have the MovieRow Widget creaeted that handles MovieCard, we can just call that here
//in DetailScreen and pass in movie = newMovieList.first //same as newMovieList[0]. Basically all
//I have to do is call MovieRow in DetailScreen and pass in the data which is the fileterd
//newMovieList.

//Now Create Horizontal Scrollable containing all that images pertaining to specific movie.
