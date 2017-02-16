figure;
m = complexmat(1000, -2+i, 1-i);
v = arrayfun(@(x) converge(x), m);
image(v);

figure;
m = complexmat(1000, -0.7+0.7i, -0.5 + 0.6i);
v = arrayfun(@(x) converge(x), m);
image(v);

figure;
m = complexmat(1000, -1.4 + 0.48i, -1.1 + 0.24i);
v = arrayfun(@(x) converge(x), m);
image(v);

figure;
m = complexmat(1000, -1.8 + 0.03i, -1.5-0.03i);
v = arrayfun(@(x) converge(x), m);
image(v);

figure;
m = complexmat(1000, -0.18 - 1.02i, -0.14 - 1.05i);
v = arrayfun(@(x) converge(x), m);
image(v);