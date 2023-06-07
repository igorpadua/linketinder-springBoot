FROM node:latest as angular
workdir /app
COPY package.json /app
RUN npm install --silent
COPY . .
RUN npm run build --prod

FROM nginx:alpine
VOLUME /var/cache/nginx
COPY --from=angular /app/dist/frontend /usr/share/nginx/html
COPY ./config/nginx.conf /etc/nginx/conf.d/default.conf

# docker build build -t curso-angular .
# docker run -p 8081:80 curso-angular
