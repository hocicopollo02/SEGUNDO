mymember(E, [E, _]).
mymember(E, [_|L]) :- mymember(E,L).

