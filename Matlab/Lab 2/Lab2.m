%% D2

p = poly([-5 -4 2 8]);
x = linspace(-50, 50);

plot(x, polyval(p, x));
axis([-50, 50, -750, 750]);

%% D4

g = @(x) cos(exp(1).^x)./(1 - x);
min = fminbnd(g, 2, 3);
fprintf('Min: %d\n', min);

x = linspace(2, 3);
plot(x, g(x));

%% D7

