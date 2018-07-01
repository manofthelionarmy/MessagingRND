# Socketapp

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 6.0.8.

## Important Dependencies

This project uses StompJs, SockJs, and Bootstrap and this repository doesn't contain the node_modules folder. After you clone this repository, navigate via your terminal to the location of this angular project (/socketapp). Once you are within the project, run:

`npm install`

to install all of the node modules. 

Then run:

`npm install stompjs --save <br>
npm install sockjs-client --save <br>
npm install bootstrap`

Bootstrap needs 2 dependencies so run:

`npm install jquery@1.9.1 --save <br>
npm install popper.js@1.14.3 --save`

After running all of these commands, the project should function properly.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
