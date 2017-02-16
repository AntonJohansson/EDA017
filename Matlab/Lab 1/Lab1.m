%% D2

pi
sqrt(3)
sqrt(-3)
sqrt(i)
exp(1)^(pi*i)

%% D3

z = sqrt(i);
abs(z)
angle(z)

z = exp(1)^(pi*i);
real(z)
imag(z)


%% D4

a = 3 + 2i;
b = 5 - 1i;
x = a * b

%% D5

g = @(x) exp(1).^(-0.1*x) .* cos(x);
g(0)
g(2)

%% D7

g = @(x) exp(1).^(-0.1*x) .* cos(x);

x = linspace(0, 10);
y = g(x);

plot(x, y);

%% D8

h = 1e-6;
deriv = @(f, x) (f(x + h) - f(x))./h;

error = deriv(@sin, 0) - cos(0)

%% D9

g = @(x) exp(1).^(-0.1*x) .* cos(x);
x = linspace(0, 10);
y = g(x);

h = 1e-6;
deriv = @(f, x) (f(x + h) - f(x))./h;

hold on;
plot(x, y);
plot(x, deriv(g, x), 'r');

title('Funktionen och dess derivata');
legend('funktion', 'derivata');
print('funktionsbild', '-dpng');


%% D10

g = @(x) exp(1).^(-0.1*x) .* cos(x);
x = linspace(0, 10);

h = 1e-6;
deriv = @(f, x) (f(x + h) - f(x))./h;

h1 = @(x) exp(1).^(-0.1*x) .* cos(x) - 0.1*exp(1).^(-0.1*x).*sin(x);
h2 = @(x) -0.1*exp(1).^(-0.1*x) .* cos(x) - exp(1).^(-0.1*x).*sin(x);
h3 = @(x) -0.1*exp(1).^(-0.1*x) .* cos(x) - 0.1*exp(1).^(-0.1*x).*sin(x);

y0 = deriv(g, x);
y1 = h1(x);
y2 = h2(x);
y3 = h3(x);

dy1 = y1 - y0;
dy2 = y2 - y0;
dy3 = y3 - y0;

norm(dy1)
norm(dy2)
norm(dy3)