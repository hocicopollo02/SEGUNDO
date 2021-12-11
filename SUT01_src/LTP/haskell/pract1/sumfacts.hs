module Sumfacts where
  import Factorial
  sumfacts :: Int -> Int
  sumfacts n = if n == 1 then fact 1 else fact n + fact (n - 1) 
