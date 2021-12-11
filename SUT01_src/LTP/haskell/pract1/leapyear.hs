module Leapyear where 
  leapyear :: Int -> Bool
  leapyear n = if mod n 4 == 0 then
               if mod n 400 == 0 then True 
               else False 

