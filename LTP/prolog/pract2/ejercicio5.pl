myappend([], L,L).
myappend([E|L1], L2, [X|L3]) :- X = E, myappend(L1, L2, L).
