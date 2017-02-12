# Application Flow


### User Sign up

1. User chooses sign up on the menu (available on all pages, unless the user 
is signed in already).
1. User fills out the sign up form and submits.
1. Request goes to sign up servlet.
1. Servlet creates a user object and then creates user in the database.
1. Response to user confirming addition (show a message on the jsp)

### User Sign In

1. User chooses sign in on the menu (available on all pages, unless the user 
is signed in already).
1. User enters username and password on form and submits. 
1. If user is authenticated, the server will handle allowing access to edit 
pages.  JDBCRealm used for authentication (users, users_roles, and roles table).
1. If authentication fails, show error message/page.

### View Collection

1. Page sends a request to view all of user's collection.
1. Servlet uses the collection dao to return all collections.
1. Dao performs select and creates collection objects from results.
1. Dao returns list of all the collections.
1. Servlet sends list back to collection jsp.
1. Collection jsp displays the collections.
1. Consider paging results so page does not get super long and too much data 
is sent.

### View Cards

1. Page sends a request to  servlet 
along with criteria to view all cards in a collectgion.
1. Servlet uses the cards dao to select cards according to criteria
1. Dao performs select and creates card objects from results.
1. Dao returns list of cards matching criteria to servlet.
1. Servlet sends list back to Card  jsp.
1. Card jsp displays the list of cards.
1. Consider paging results so page does not get super long and too much data 
is sent.

### View Cards Details

1. Page sends a request to  servlet 
along with criteria to view a card details.
1. Servlet uses the webservice to get details about a card.
1. Servlet creates an object based on the info from webservice.
1. Servlet sends details back to CardDetails  jsp.
1. CardDetails jsp displays the card details.

### About

1. Static page - html only? 
1. Consider making contact info configurable.

### Add Collection
1. User fills up the collection form
1. Details are sent to Add Card servlet
1. Servlet creates Collection object
1. Servlet sends object to dao
1. Dao adds collection to the database
1. Servlet sends confirmation to collection page that collection has been added.

### Add Card
1. User enters Card user details
1. Details are sent to Add Card  servlet
1. Servlet creates Card  object
1. Servlet sends object to dao
1. Dao adds card to the database
1. Servlet sends confirmation to card page that card has been added.








 
