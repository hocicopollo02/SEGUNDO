module Geometry2D where
	areaRectangle :: Float -> Float -> Float
	areaRectangle base height = base * height
	perimeterRectangle :: Float -> Float -> Float
	perimeterRectangle base height = 2 * (base + height)
	areaSquare :: Float -> Float
	areaSquare lado = lado * lado
	perimeterSquare :: Float -> Float
	perimeterSquare lado = 4 * lado
	
