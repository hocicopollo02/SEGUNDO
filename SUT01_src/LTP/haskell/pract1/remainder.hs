module Remainder where
  remainder :: Int -> Int -> Int
  remainder a b = if a < b then a else remainder (a - b) b
