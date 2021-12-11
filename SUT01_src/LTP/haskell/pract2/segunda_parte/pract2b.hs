module Biblio where
	
	obtain :: Database -> Person -> [Book]
	obtain dBase thisPerson = [book | (person, book) <- dBase, person == thisPerson

	borrow :: Database -> Book -> Person -> Database
	borrow dBase thisBook thisPerson
		| null ([book | book <- obtain dBase thisPerson, thisBook == book]) = dBase++[(thisPerson, thisBook)]
		| otherwise = dBase 
