%% Komplexa tal
 
a = 3 + 2i;
b = 5 - 1i;
x = a * b

%% Funktioner

g = @(x) exp(1).^(-0.1*x) .* cos(x);
h1 = @(x) exp(1).^(-0.1*x) .* cos(x) - 0.1*exp(1).^(-0.1*x).*sin(x);
h2 = @(x) -0.1*exp(1).^(-0.1*x) .* cos(x) - exp(1).^(-0.1*x).*sin(x);
h3 = @(x) -0.1*exp(1).^(-0.1*x) .* cos(x) - 0.1*exp(1).^(-0.1*x).*sin(x);

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