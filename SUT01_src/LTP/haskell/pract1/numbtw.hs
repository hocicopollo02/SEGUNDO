module Numbtw where
  import Data.Char
  numbtw :: Char -> Char -> Int
  numbtw a b = abs (ord b - ord a) - 1
  
