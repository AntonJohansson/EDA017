%% D1

p = [1 3 -87 -307 822 2160];
x = roots(p)
y = polyval(p, x)

%% D2

p = poly([-5 -4 2 8]);
x = linspace(-50, 50);

plot(x, polyval(p, x));
axis([-50, 50, -750, 750]);

%% D3

f = @(t) 4*sin(3*t) + 3*exp(1).^(-0.5*t);
S = integral(f, 1.4, 3.1)

%% D4

g = @(x) cos(exp(1).^x)./(1 - x);
min = fminbnd(g, 2, 3);
y = g(min);

fprintf('Min: x = %d\ng(x) = %d\n', min, y);

x = linspace(2, 3);
plot(x, g(x));
grid on;

%% D5

h = @(x) 3*exp(1).^(-x.^2) - 9*x.^2 + x;
g = @(x) -h(x);

fplot(h, [-10 10]);

x_roots = [fzero(h, 0) fzero(h, 0.2)]
y_roots = g(x_roots)

max = fminbnd(g, -50, 50)
ymax = h(max)

%% D6

rows = 7;
M = eye(rows) + 5*diag(ones(rows-1, 1), 1) + 5*diag(ones(rows-1, 1), -1)