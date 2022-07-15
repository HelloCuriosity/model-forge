import React from 'react';
import clsx from 'clsx';
import styles from './styles.module.css';

const FeatureList = [
  {
    title: 'Auto Generate Models',
    Svg: require('@site/static/img/undraw_docusaurus_mountain.svg').default,
    description: (
      <>
        Model forge <strong>auto generates</strong> models for use in unit or integration tests. Removing the need to create
        static models and removes redundancy in your tests.
      </>
    ),
  },
  {
    title: 'Extendability',
    Svg: require('@site/static/img/undraw_docusaurus_tree.svg').default,
    description: (
      <>
        Model forge can easily be <strong>extended</strong> with custom providers, helping you specify distinct behavior where
        needed.
      </>
    ),
  },
  {
    title: 'Android Friendly',
    Svg: require('@site/static/img/undraw_docusaurus_react.svg').default,
    description: (
      <>
        Model forge can be used in jvm and <strong>android</strong> projects alike.
      </>
    ),
  },
  {
    title: 'Open-Source',
    Svg: require('@site/static/img/undraw_docusaurus_react.svg').default,
    description: (
      <>
        Model forge is <strong>open-source</strong> and developed by the community. Help us shape the future by joining us
        on GitHub.
      </>
    ),
  },
];

function Feature({Svg, title, description}) {
  return (
    <div className={clsx('col col--6')}>
      <div className="text--center">
        <Svg className={styles.featureSvg} role="img"/>
      </div>
      <div className="text--center padding-horiz--md">
        <h3>{title}</h3>
        <p>{description}</p>
      </div>
    </div>
  );
}

export default function HomepageFeatures() {
  return (
    <section className={styles.features}>
      <div className="container">
        <div className="row">
          {FeatureList.map((props, idx) => (
            <Feature key={idx} {...props} />
          ))}
        </div>
      </div>
    </section>
  );
}
