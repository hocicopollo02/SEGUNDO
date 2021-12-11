module Addrange where
  addrange :: Int -> Int -> Int
  addrange a b = if a == b then 0 else
                 if a > b then sum [b..a] else sum [a..b] 
