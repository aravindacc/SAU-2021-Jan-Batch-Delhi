#  API Setup
    You need Json-server and Axios 
    Run These Commands
  `npm i --g json-server`
  `npm i --g axios`
  
    Go to "api" directory 
    open cmd here and Start Json-server 
    Run 
`json-server --watch products.json`

    Now to actually use it on your native app 
    You need to make a tunnel 
    Open a new cmd terminal 
    Run
`npx ngrok http 3000`

    Now you will get a "ngrok.io" link put this link in 
    Go to Assignment->components->HomeComponent.js 
    put this link in line no 17.
    And you are good to go.


